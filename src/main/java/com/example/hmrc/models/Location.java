package com.example.hmrc.models;

public class Location {
    private final String latitude;
    private final String longitude;
    private final String postcode;

    public Location(String latitude, String longitude, String postcode) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.postcode = postcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPostcode() {
        return postcode;
    }
}
