package com.assignment10.service;

import com.assignment10.dto.DayResponse;
import com.assignment10.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class MealService {
    RestTemplate dietTemplate1= new RestTemplate();
    RestTemplate dietTemplate2= new RestTemplate();
    @Autowired
    private String apiKey;
    @Autowired
    private String spoonacularBaseUrl;
    @Autowired
    private String mealPlanEndPoint;


    public WeekResponse Weekly (String targetCalories, String diet, String exclude){
        String uribuilder = getUribuilder("week",targetCalories, diet, exclude);

        return dietTemplate1.getForObject(uribuilder,WeekResponse.class);
    }

    public DayResponse daily (String targetCalories, String diet, String exclude){
        String uribuilder2 = getUribuilder("day", targetCalories, diet, exclude);
        
        return dietTemplate2.getForObject(uribuilder2,DayResponse.class);
    }
    private String getUribuilder(String timeFrame, String targetCalories, String diet, String exclude) {
        String uribuilder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("timeFrame", timeFrame)
                .queryParam("targetCalories",Optional.ofNullable(targetCalories))
                .queryParam("diet",Optional.ofNullable(diet))
                .queryParam("exclude",Optional.ofNullable(exclude))
                .queryParam("appkey",apiKey)
                .build().toUriString();
        return uribuilder;
    }
}
