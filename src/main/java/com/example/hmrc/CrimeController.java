package com.example.hmrc;

import com.example.hmrc.Builder.ResponseBuilder;
import com.example.hmrc.IntegrationModels.IntCategory;
import com.example.hmrc.IntegrationModels.IntCrime;
import com.example.hmrc.IntegrationModels.IntPostcodeResponse;
import com.example.hmrc.Services.HttpService;
import com.example.hmrc.Validation.Validator;
import com.example.hmrc.models.Categories;
import com.example.hmrc.models.Crime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

@RestController
public class CrimeController {

    @GetMapping("/crime/categories")
    public Categories getCategories() {
        ResponseEntity<IntCategory[]> response;
        try {
            response = HttpService.getCategories();
        } catch (HttpClientErrorException e) {
            throw new NoSuchElementException("no categories can be found");
        }
        return ResponseBuilder.buildCategoriesResponse(response);
    }

    @GetMapping("/crimes")
    public Crime[] getCrimes(@RequestParam(value="postcode") String postcode, @RequestParam(value="date") String date) {
        if(!Validator.isPostcodeValid(postcode) || !Validator.isDateValid(date)) {
            throw new InvalidParameterException("parameters are wrong");
        }

        IntPostcodeResponse intPostcodeResponse;
        try {
            intPostcodeResponse = HttpService.getPostcode(postcode);
        } catch (HttpClientErrorException e) {
            throw new InvalidParameterException("parameters are wrong");
        }

        ResponseEntity<IntCrime[]> intCrimeResponse;
        try {
            intCrimeResponse = HttpService.getCrimes(date,intPostcodeResponse);
        } catch (HttpClientErrorException e) {
            throw new NoSuchElementException("no data found");
        }

        return ResponseBuilder.buildCrimesResponse(intCrimeResponse,postcode);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidParameterException.class)
    public void return400() {}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void return404() {}
}
