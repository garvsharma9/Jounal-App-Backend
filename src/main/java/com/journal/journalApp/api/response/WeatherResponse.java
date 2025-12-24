package com.journal.journalApp.api.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse{
    public Current current;





    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current{
        private Integer temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        private Integer feelslike;
    }


}





