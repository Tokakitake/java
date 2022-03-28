package homeWork8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.sqlite.JDBC;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    private final static String PATH_DB = "jdbc:sqlite:src/main/java/homeWork8/Weather.db";

    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_DB);
    }

    static OkHttpClient client = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    //add
    public void addWeather() throws IOException {

        HttpUrl detectWeather = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("332287")
                .addQueryParameter("apikey", "4gaAPV4sBrVcfcXRxRfrvGq0BbAsKSp4")
                .addQueryParameter("metric", "true")
                .build();

        Request requestWeather = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(detectWeather)
                .build();

        HttpUrl detectCity = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("332287")
                .addQueryParameter("apikey", "4gaAPV4sBrVcfcXRxRfrvGq0BbAsKSp4")
                .build();

        Request requestCity = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(detectCity)
                .build();

        Response responseCity = client.newCall(requestCity).execute();
        Response responseWeather = client.newCall(requestWeather).execute();

        String jsonOfCity = responseCity.body().string();
        String jsonOfWeather = responseWeather.body().string();

        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement("INSERT INTO Weather('city', 'LocalDate', 'weather', 'TemperatureMin', 'TemperatureMax') " +
                    "VALUES(?, ?, ?, ?, ?)"
            );
            statement.setObject(1, objectMapper.readTree(jsonOfCity).at("/LocalizedName").asText());
            statement.setObject(2, objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Date").asText());
            statement.setObject(3, objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Day/IconPhrase").asText());
            statement.setObject(4, String.valueOf(objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asDouble()));
            statement.setObject(5, String.valueOf(objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asDouble()));
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //SELECT
    public List<Weather> getAllWeather() throws SQLException {
        List<Weather> weather = new ArrayList<>();
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Weather");

        while (resultSet.next()) {
            String city = resultSet.getString("city");
            String LocalDate = resultSet.getString("LocalDate");
            String weatherDay = resultSet.getString("weather");
            double TemperatureMin = resultSet.getDouble("TemperatureMin");
            double TemperatureMax = resultSet.getDouble("TemperatureMax");
            Weather weatherData = new Weather(city, LocalDate, weatherDay, TemperatureMin, TemperatureMax);
            weather.add(weatherData);

        }

        return weather;

    }

}
