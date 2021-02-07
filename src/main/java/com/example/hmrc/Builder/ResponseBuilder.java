package com.example.hmrc.Builder;

import com.example.hmrc.IntegrationModels.IntCategory;
import com.example.hmrc.IntegrationModels.IntCrime;
import com.example.hmrc.models.Categories;
import com.example.hmrc.models.Crime;
import com.example.hmrc.models.Location;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class ResponseBuilder {

    public static Categories buildCategoriesResponse(ResponseEntity<IntCategory[]> response) {
        String[] categoriesArray = Arrays.stream(response.getBody()).map(category -> category.getName()).toArray(String[]::new);
        return new Categories(categoriesArray);
    };

    public static Crime[] buildCrimesResponse(ResponseEntity<IntCrime[]> crimeResponse, String postcode) {
        return Arrays.stream(crimeResponse.getBody()).map(c -> {
            Location location = new Location(c.getLocation().getLatitude(),c.getLocation().getLongitude(), postcode);
            String outComeStatus = "";
            if(c.getOutcome_status() != null) {
                outComeStatus = c.getOutcome_status().getCategory();
            }
            return new Crime(c.getCategory(),location,c.getContext(),outComeStatus,c.getMonth());
        }).toArray(Crime[]::new);
    };
}
