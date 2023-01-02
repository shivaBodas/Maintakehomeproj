package com.example.takehome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    private Country country;

    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(Country country) {
        this.country = country;
    }
}
