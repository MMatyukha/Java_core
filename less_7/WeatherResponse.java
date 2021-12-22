package javacore.weather;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class WeatherResponse {
    String cityName;
    List<Weather> dailyWeather;

    public WeatherResponse(List<Weather> dailyWeather) {
        this.dailyWeather = dailyWeather;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Weather> getDailyWeather() {
        return dailyWeather;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Weather weather: dailyWeather) {
            builder.append(
                    String.format(
                            "В городе %s на дату %s ожидается %s, температура - %.1f.\n",
                            cityName,
                            weather.getDate().format(DateTimeFormatter.ISO_DATE),
                            weather.getDescription(),
                            weather.getTemperature()
                    )
            );
        }
        return builder.toString();
    }
}
