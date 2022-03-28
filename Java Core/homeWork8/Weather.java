package homeWork8;

public class Weather {

    private String city;
    private String LocalDate;
    private String weather;
    private double TemperatureMin;
    private double TemperatureMax;

    public Weather(String city, String localDate, String weather, double temperatureMin, double temperatureMax) {
        this.city = city;
        LocalDate = localDate;
        this.weather = String.valueOf(weather);
        TemperatureMin = temperatureMin;
        TemperatureMax = temperatureMax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return LocalDate;
    }

    public void setLocalDate(String localDate) {
        LocalDate = localDate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemperatureMin() {
        return TemperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        TemperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return TemperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        TemperatureMax = temperatureMax;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", LocalDate='" + LocalDate + '\'' +
                ", weather='" + weather + '\'' +
                ", TemperatureMin=" + TemperatureMin +
                ", TemperatureMax=" + TemperatureMax +
                '}';
    }
}
