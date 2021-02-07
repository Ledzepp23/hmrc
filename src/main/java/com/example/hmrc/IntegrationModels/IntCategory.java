package com.example.hmrc.IntegrationModels;

public class IntCategory {
    private String url;
    private String name;

    public IntCategory() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "url: " + url + " and name: " + name + " -- ";
    }
}
