package com.journal.journalApp.Services;

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


    public WeatherResponse getWeather(String city){
        String finalApi=appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", apiKey);

        System.out.println(finalApi);
//        String finalApi="http://api.weatherstack.com/current?access_key=38d81855b0adadf230afa26b9f31aedb&query=CITYhttp://api.weatherstack.com/current?access_key=API_KEY&query=Mumbai";
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);

        WeatherResponse body = response.getBody();
        return body;
    }
}
