package com.example.takehome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Continent {
    private String name;
    private CountryIn[] countries;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("countries")
    public CountryIn[] getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public void setCountries(CountryIn[] countries) {
        this.countries = countries;
    }
}
