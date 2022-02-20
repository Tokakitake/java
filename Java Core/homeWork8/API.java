package homeWork8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class API {

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


        String city = objectMapper.readTree(jsonOfCity).at("/LocalizedName").asText();
        String date = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Date").asText();
        String weatherDay = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Day/IconPhrase").asText();
        String weatherNight = objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Night/IconPhrase").asText();
        String temperatureMin = String.valueOf(objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asDouble());
        String temperatureMax = String.valueOf(objectMapper.readTree(jsonOfWeather).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asDouble());

        return "В городе " + city + " на дату " + date + " ожидается " + weatherDay + " днем и " + weatherNight + " вечером," + " температура " + temperatureMin + " - " + temperatureMax;

    }
}