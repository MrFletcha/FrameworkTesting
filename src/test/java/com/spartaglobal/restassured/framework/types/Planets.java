package com.spartaglobal.restassured.framework.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.spartaglobal.restassured.framework.controller.ValueInjector;

public class Planets {

    @JsonProperty("name")
    private String name;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    @JsonProperty("diameter")
    private String diameter;
    @JsonProperty("climate")
    private String climate;
    @JsonProperty("gravity")
    private String gravity;
    @JsonProperty("terrain")
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    @JsonProperty("population")
    private String population;
    @JsonProperty("residents")
    private List<String> residents = null;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;

    List<String> arr = new ArrayList<>();

    public String getName() { return name; }

    public String getRotationPeriod() { return rotationPeriod; }

    public String getOrbitalPeriod() { return orbitalPeriod; }

    public String getDiameter() { return diameter; }

    public String getClimate() { return climate; }

    public String getGravity() { return gravity; }

    public String getTerrain() { return terrain; }

    public String getSurfaceWater() { return surfaceWater; }

    public String getPopulation() { return population; }

    public List<String> getResidents() { return residents; }

    public List<String> getFilms() { return films; }

    public String getCreated() { return created; }

    public String getEdited() { return edited; }

    public String getUrl() { return url; }


    public String hasResidents(String person)
    {
        arr = getResidents();
        People people;
        for (String s : arr) {
            people = (People) ValueInjector.createDTO(s);
            if (person.equals(people.getName())) {
                return people.getName() + " is a Resident";
            }
        }
        return "No Residents found with this name";
    }

    public String inFilm(String film)
    {
        arr = getFilms();
        Films films;
        for (String s : arr) {
            films = (Films) ValueInjector.createDTO(s);
            if (film.equals(films.getTitle())) {
                return "Is in this Film: " + films.getTitle();
            }
        }
        return "Not in this Film";
    }

}
