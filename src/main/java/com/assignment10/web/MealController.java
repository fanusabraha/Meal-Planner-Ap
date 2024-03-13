package com.assignment10.web;
import com.assignment10.dto.WeekResponse;
import com.assignment10.dto.DayResponse;
import com.assignment10.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mealplanner")
public class MealController {
    // API Key b24e9a29a86b4a619b17595ff2d6ff2b
    @Autowired
    MealService mealService;
    private WeekResponse weekResponse;
    private DayResponse dayResponse;

    @GetMapping("/week")

    public ResponseEntity<WeekResponse> getWeekMeals( String numCalories, String diet, String exclusions){

     weekResponse = mealService.Weekly(numCalories,diet,exclusions);
     return ResponseEntity.ok(weekResponse);

    }
    @GetMapping("/day")

    public ResponseEntity<DayResponse> getDayMeals( String numCalories, String diet, String exclusions) {

    dayResponse = mealService.daily(numCalories,diet,exclusions);
        return ResponseEntity.ok(dayResponse);
    }
}

