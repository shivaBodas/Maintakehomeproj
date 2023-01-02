package com.example.takehome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContinetOutput {

    private Output continent;

    @JsonProperty("continent")
    public Output getContinent() {
        return continent;
    }

    public void setContinent(Output continent) {
        this.continent = continent;
    }
}
