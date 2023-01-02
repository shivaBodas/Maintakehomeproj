package com.example.takehome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Output {
    private Set<String> countrys= new HashSet<>();
    private  String name;
    private  Set<String> otherCountrys = new HashSet<>();

    @JsonProperty("countrys")
    public Set<String> getCountrys() {
        return  countrys;
    }

    public void setCountrys(Set<String> countrys) {
        this.countrys = countrys;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("otherCountrys")
    public Set<String> getOtherCountry() {
        return otherCountrys;
    }

    public void setOtherCountry(Set<String> otherCountry) {
        this.otherCountrys = otherCountry;
    }
}
