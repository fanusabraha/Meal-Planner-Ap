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
    @Autowired
    RestTemplate dietRestTemplate;
    @Autowired
    private String apiKey;
    @Autowired
    private String spoonacularBaseUrl;
    @Autowired
    private String mealPlanEndPoint;


    public WeekResponse Weekly (String targetCalories, String diet, String exclude){
        String uribuilder = getUribuilder("week",targetCalories, diet, exclude);

        return dietRestTemplate.getForObject(uribuilder,WeekResponse.class);
    }

    public DayResponse daily (String targetCalories, String diet, String exclude){
        String uribuilder2 = getUribuilder("day", targetCalories, diet, exclude);
        
        return dietRestTemplate.getForObject(uribuilder2,DayResponse.class);
    }
    private String getUribuilder(String timeFrame, String targetCalories, String diet, String exclude) {
        return   UriComponentsBuilder.fromHttpUrl(spoonacularBaseUrl+mealPlanEndPoint)
                .queryParam("timeFrame", timeFrame)
                .queryParamIfPresent("targetCalories",Optional.ofNullable(targetCalories))
                .queryParamIfPresent("diet",Optional.ofNullable(diet))
                .queryParamIfPresent("exclude",Optional.ofNullable(exclude))
                .queryParam("apiKey",apiKey)
                .build().toUriString();

    }
}
