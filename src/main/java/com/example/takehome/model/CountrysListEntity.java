package com.example.takehome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountrysListEntity {
    private Data data;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }
}
