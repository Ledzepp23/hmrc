package com.example.hmrc.IntegrationModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntPostcodeResponse {
    private String status;
    private IntPostcode result;

    public IntPostcodeResponse() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IntPostcode getResult() {
        return result;
    }

    public void setResult(IntPostcode result) {
        this.result = result;
    }
}
