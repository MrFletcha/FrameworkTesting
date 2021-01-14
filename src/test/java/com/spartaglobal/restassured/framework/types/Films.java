package com.spartaglobal.restassured.framework.types;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spartaglobal.restassured.framework.controller.ValueInjector;

public class Films {

    @JsonProperty("title")
    private String title;
    @JsonProperty("episode_id")
    private Integer episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("characters")
    private List<String> characters = null;
    @JsonProperty("planets")
    private List<String> planets = null;
    @JsonProperty("starships")
    private List<String> starships = null;
    @JsonProperty("vehicles")
    private List<String> vehicles = null;
    @JsonProperty("species")
    private List<String> species = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;

    List<String> arr = new ArrayList<>();

    public String getTitle() { return title; }

    public Integer getEpisodeId() { return episodeId; }

    public String getOpeningCrawl() { return openingCrawl; }

    public String getDirector() { return director; }

    public String getProducer() { return producer; }

    public String getReleaseDate() { return releaseDate; }

    public List<String> getCharacters() { return characters; }

    public List<String> getPlanets() { return planets; }

    public List<String> getStarships() { return starships; }

    public List<String> getVehicles() { return vehicles; }

    public List<String> getSpecies() { return species; }

    public String getCreated() { return created; }

    public String getEdited() { return edited; }

    public String getUrl() { return url; }

    public String hasShip(String ship)
    {
        arr = getStarships();
        Starship starship;
        for (String s : arr) {
            starship = (Starship) ValueInjector.createDTO(s);
            if (ship.equals(starship.getName())) {
                return starship.getName() + " is in this Film";
            }
        }
        return "No starship with this name found";
    }

    public String hasCharacters(String character)
    {
        arr = getCharacters();
        People people;
        for (String s : arr) {
            people = (People) ValueInjector.createDTO(s);
            if (character.equals(people.getName())) {
                return people.getName() + " is in this Film";
            }
        }
        return "This film doesn't have this Character in it.";
    }

    public String hasVehicle(String vehicle)
    {
        arr = getVehicles();
        Vehicles vehicles;
        for (String s : arr) {
            vehicles = (Vehicles) ValueInjector.createDTO(s);
            if (vehicle.equals(vehicles.getName())) {
                return vehicles.getName() + " is in this Film";
            }
        }
        return "This Film doesn't have this vehicle";
    }

    public String hasPlanet(String planet)
    {
        arr = getVehicles();
        Planets planets;
        for (String s : arr) {
            planets = (Planets) ValueInjector.createDTO(s);
            if (planet.equals(planets.getName())) {
                return planets.getName() + " is in this Film";
            }
        }
        return "This film doesn't have this planet";
    }
}
