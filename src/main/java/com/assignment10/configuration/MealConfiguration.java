package com.assignment10.configuration;

import com.assignment10.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MealConfiguration {
    @Value("${apiKey}")
    private String apiKeySpooncular;
    @Value("spoonacular.urls.base")
    private String spoonacularBaseUrlUserFanus;
    @Value("spoonacular.urls.mealplan")
    private String mealPlanEndPointUserFanus;

    @Bean
    public String apiKey(){return apiKeySpooncular;}
    @Bean
    public String spoonacularBaseUrl(){return spoonacularBaseUrlUserFanus;}
    @Bean
    public String mealPlanEndPoint(){return mealPlanEndPointUserFanus;}
}
