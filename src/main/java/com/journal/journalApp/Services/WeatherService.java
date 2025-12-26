package com.journal.journalApp.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.journal.journalApp.api.response.WeatherResponse;
import com.journal.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import com.journal.journalApp.Entity.User;
@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;

    private String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
    @Autowired
    private AppCache appCache;
    @Autowired
    private RestTemplate restTemplate ;
    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) throws JsonProcessingException {

        WeatherResponse weatherResponse = redisService.get("Weather_of_" + city, WeatherResponse.class);
        if(weatherResponse!=null)
        {
            return weatherResponse;
        }
        else {
            String finalApi=appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", apiKey);

            System.out.println(finalApi);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);

            WeatherResponse body = response.getBody();
            if(body!=null)
            {
                redisService.set("Weather_of_" + city, body, 300l );
            }
            return body;
        }

    }
}
