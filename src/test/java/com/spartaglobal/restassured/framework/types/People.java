package com.spartaglobal.restassured.framework.types;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spartaglobal.restassured.framework.controller.ValueInjector;

import static io.restassured.RestAssured.given;

public class People{


    public People() { }

    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private String height;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("species")
    private List<Object> species = null;
    @JsonProperty("vehicles")
    private List<String> vehicles = null;
    @JsonProperty("starships")
    private List<String> starships = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;

    List<String> arr = new ArrayList<>();

    public String getName() { return name; }

    public String getHeight() { return height;}

    public String getMass() { return mass; }

    public String getHairColor() { return hairColor; }

    public String getSkinColor() { return skinColor; }

    public String getEyeColor() { return eyeColor; }

    public String getBirthYear() { return birthYear; }

    public String getGender() { return gender; }

    public String getHomeworld() { return homeworld; }

    public List<String> getFilms() { return films; }

    public List<Object> getSpecies() { return species; }

    public List<String> getVehicles() { return vehicles; }

    public List<String> getStarships() { return starships; }

    public String getCreated() { return created; }

    public String getEdited() { return edited; }

    public String getUrl() { return url; }


    //Additional methods for Testing

    //Set of array checkers to see if the Ship, Film or Vehicle is in the characters profile
    public String hasShip(String ship)
    {
        arr = getStarships();
        Starship starship;
        for (String s : arr) {
            starship = (Starship) ValueInjector.createDTO(s);
            if (ship.equals(starship.getName())) {
                return "Has this Starship: " + starship.getName();
            }
        }
        return "No starship with this name found";
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

    public String hasVehicle(String vehicle)
    {
        arr = getVehicles();
        Vehicles vehicles;
        for (String s : arr) {
            vehicles = (Vehicles) ValueInjector.createDTO(s);
            if (vehicle.equals(vehicles.getName())) {
                return "Is in this Film: " + vehicles.getName();
            }
        }
        return "This character doesn't have it";
    }
}
