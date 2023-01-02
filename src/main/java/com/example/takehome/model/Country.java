package com.example.takehome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    private String name;
    private Continent continent;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("continent")
    public Continent getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
