# Meal Planner App Using Spoonacular API

## Overview

This project is a Java-based web application that integrates with the Spoonacular API to generate daily and weekly meal plans. Users can customize meal plans by setting calorie limits, diet preferences, and food exclusions.

---

## What You’ll Learn

1. **API Integration**
   - Register for and use an API key to interact with Spoonacular's meal planning endpoints.
   - Send GET requests with query parameters to retrieve dynamic data.

2. **Spring Boot Basics**
   - Create a web app using Spring Boot.
   - Define REST controllers and endpoints.
   - Use Maven for project management.

3. **Data Representation**
   - Map JSON responses from the API into Java objects.
   - Work with custom response objects (e.g., `WeekResponse` and `DayResponse`).

4. **Testing with Postman**
   - Validate your application’s endpoints by sending requests with different parameters.

---

## Setup and Instructions

### Step 1: API Registration
1. **Register** at [Spoonacular API Console](https://spoonacular.com/food-api/console#Dashboard).
2. Retrieve your **API Key** and save it securely.
3. Note: All API requests require the `apiKey` parameter.

### Step 2: Spring Boot Project Setup
1. Visit [start.spring.io](https://start.spring.io/).
2. Add the following:
   - **Java 11** (in the advanced section).
   - **Web dependency**.
3. Download the generated ZIP file and extract it into a directory.
4. Import the project into Eclipse:
   - Go to `Import > Maven > Existing Maven Project`.
   - Select the `pom.xml` file.

### Step 3: Build the Controller
1. Create a controller with the following endpoints:

   ```java
   @GetMapping("mealplanner/week")
   public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions);

   @GetMapping("mealplanner/day")
   public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions);
   ```

2. Use the Spoonacular [Generate Meal Plan API Documentation](https://spoonacular.com/food-api/docs#Generate-Meal-Plan) to map JSON responses into Java classes (`WeekResponse` and `DayResponse`).

---

## Testing the Application

1. **Use Postman**:
   - Send GET requests to:
     - `/mealplanner/week`
     - `/mealplanner/day`
   - Include query parameters:
     - `numCalories`
     - `diet`
     - `exclusions`
   - Verify that the API response adheres to the provided input.

2. Example GET Request:
   ```
   GET http://localhost:8080/mealplanner/week?numCalories=2000&diet=vegetarian&exclusions=gluten
   ```

---

## Bonus Challenge

1. **Property File Configuration**:
   - Extract the base URL and endpoint paths into `application.properties`:

     ```
     spoonacular.urls.base=https://api.spoonacular.com
     spoonacular.urls.mealplan=/mealplanner/generate
     ```

   - Retrieve these values in your code using `@Value` annotation:

     ```java
     @Value("${spoonacular.urls.base}")
     private String baseUrl;

     @Value("${spoonacular.urls.mealplan}")
     private String mealPlanEndpoint;
     ```

2. **Dynamic URL Construction**:
   - Construct API requests dynamically using properties, making your code cleaner and easier to maintain.

---

## Key Takeaways
- **API Usage**: Learn how to securely integrate and consume third-party APIs.
- **Spring Boot Framework**: Build RESTful endpoints and structure your application.
- **Postman Testing**: Test and debug your endpoints with real-world inputs.
- **Configuration Management**: Use property files to make your application more flexible and maintainable.

---

This project is a great starting point for understanding API integrations and Spring Boot development!
