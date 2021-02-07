package com.example.hmrc.IntegrationModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntCrime {
    private String category;
    private IntLocation intLocation;
    private String context;
    private IntOutcomeStatus outcome_status;
    private String month;

    public IntCrime() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public IntLocation getLocation() {
        return intLocation;
    }

    public void setLocation(IntLocation intLocation) {
        this.intLocation = intLocation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public IntOutcomeStatus getOutcome_status() {
        return outcome_status;
    }

    public void setOutcome_status(IntOutcomeStatus outcome_status) {
        this.outcome_status = outcome_status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
