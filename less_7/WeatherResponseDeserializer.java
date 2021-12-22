package javacore.weather;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WeatherResponseDeserializer extends StdDeserializer<WeatherResponse> {
    public WeatherResponseDeserializer() {
        this(null);
    }

    public WeatherResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WeatherResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode root = p.getCodec().readTree(p);
        JsonNode headline = root.get("Headline");
        String link = headline.get("Link").asText();
        JsonNode dailyForecasts = root.get("DailyForecasts");
        List<Weather> weatherList = new ArrayList<Weather>(5);
        for (Iterator<JsonNode> it = dailyForecasts.elements(); it.hasNext(); ) {
            JsonNode forecast = it.next();
            LocalDate date = LocalDate.parse(forecast.get("Date").asText(), DateTimeFormatter.ISO_DATE_TIME);
            double temperature = forecast.get("Temperature").get("Maximum").get("Value").asDouble();
            String description = forecast.get("Day").get("IconPhrase").asText().toLowerCase(Locale.ROOT);
            weatherList.add(new Weather(date, temperature, description));
        }
        return new WeatherResponse(weatherList);
    }

    public static void main(String[] args) {

    }
}
