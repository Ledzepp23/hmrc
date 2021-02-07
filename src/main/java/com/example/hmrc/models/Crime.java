package com.example.hmrc.models;

public class Crime {
    private final String category;
    private final Location location;
    private final String context;
    private final String outcome_status;
    private final String month;

    public Crime(String category, Location location, String context, String outcome_status, String month) {
        this.category = category;
        this.location = location;
        this.context = context;
        this.outcome_status = outcome_status;
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public Location getLocation() {
        return location;
    }

    public String getContext() {
        return context;
    }

    public String getOutcome_status() {
        return outcome_status;
    }

    public String getMonth() {
        return month;
    }
}
