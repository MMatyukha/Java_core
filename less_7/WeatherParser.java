package javacore.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.net.URL;

public class WeatherParser {

    public static void main(String[] args) {
        String requestUri = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/264120?apikey=YWVxeJgaQDP5zV8s7MlfbD2Xvlk7CgAz&language=ru&metric=true";

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(WeatherResponse.class, new WeatherResponseDeserializer());
        mapper.registerModule(module);

        try {
            URL url = new URL(requestUri);
            WeatherResponse response = mapper.readValue(url, WeatherResponse.class);
            response.cityName = "Лима";
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
