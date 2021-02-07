package com.example.hmrc.Services;

import com.example.hmrc.IntegrationModels.IntCategory;
import com.example.hmrc.IntegrationModels.IntCrime;
import com.example.hmrc.IntegrationModels.IntPostcodeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

public class HttpService {

    static RestTemplate restTemplate = new RestTemplate();

    public static ResponseEntity<IntCategory[]> getCategories() throws HttpClientErrorException{
        ResponseEntity<IntCategory[]> response;
        try {
            response = restTemplate.getForEntity(
                    "https://data.police.uk/api/crime-categories", IntCategory[].class);
        } catch(HttpClientErrorException e) {
            throw e;
        }
       return response;
    };

    public static IntPostcodeResponse getPostcode(String postcode) throws HttpClientErrorException {
        IntPostcodeResponse intPostcodeResponse;
        try {
            intPostcodeResponse = restTemplate.getForObject(
                    "http://api.postcodes.io/postcodes/" + postcode, IntPostcodeResponse.class);
        } catch (HttpClientErrorException e) {
            throw e;
        }
        return intPostcodeResponse;
    }

    public static ResponseEntity<IntCrime[]> getCrimes(String date, IntPostcodeResponse intPostcodeResponse) throws HttpClientErrorException{
        ResponseEntity<IntCrime[]> crimeResponse;
        try {
            crimeResponse = restTemplate.getForEntity(
                    "https://data.police.uk/api/crimes-at-location?date=" + date +"&lat="+
                            intPostcodeResponse.getResult().getLatitude()+"&lng="+
                            intPostcodeResponse.getResult().getLongitude(), IntCrime[].class);

        } catch (HttpClientErrorException e) {
            throw e;
        }
        return crimeResponse;
    }
}
