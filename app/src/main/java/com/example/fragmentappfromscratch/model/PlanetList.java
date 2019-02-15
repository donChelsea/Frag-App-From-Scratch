package com.example.fragmentappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetList {
    @SerializedName("planets")

    private List<Planet> planetList;

    public PlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }

    public void setPlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }
}
