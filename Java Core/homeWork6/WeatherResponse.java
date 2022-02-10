package homeWork6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class WeatherResponse {

    static OkHttpClient client = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static String getWeather() throws IOException {

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


        for (int i = 0; i <= 4; i++) {
            String city = objectMapper.readTree(jsonOfCity).at("/LocalizedName").asText();
            String date = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(i).at("/Date").asText();
            String weatherDay = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(i).at("/Day/IconPhrase").asText();
            String weatherNight = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(i).at("/Night/IconPhrase").asText();
            String temperatureMin = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(i).at("/Temperature/Minimum/Value").asText();
            String temperatureMax = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Value").asText();
            String unit = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Unit").asText();

            System.out.println("В городе " + city + " на дату " + date + " ожидается " + weatherDay + " днем и " + weatherNight + " вечером," + " температура " + temperatureMin + " - " + temperatureMax + " " + unit);

            if (i == 4) {
                System.exit(0);
            }

        }

        return null;

    }
}


