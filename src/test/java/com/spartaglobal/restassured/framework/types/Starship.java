package com.spartaglobal.restassured.framework.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Starship {

    public Starship(){}

    @JsonProperty("name")
    private String name;
    @JsonProperty("model")
    private String model;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    @JsonProperty("length")
    private String length;
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @JsonProperty("crew")
    private String crew;
    @JsonProperty("passengers")
    private String passengers;
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;
    @JsonProperty("consumables")
    private String consumables;
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    @JsonProperty("MGLT")
    private String mGLT;
    @JsonProperty("starship_class")
    private String starshipClass;
    @JsonProperty("pilots")
    private List<Object> pilots = null;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;

    public String getName() { return name; }

    public String getModel() { return model; }

    public String getManufacturer() { return manufacturer; }

    public String getCostInCredits() { return costInCredits; }

    public String getLength() { return length; }

    public String getMaxAtmospheringSpeed() { return maxAtmospheringSpeed; }

    public String getCrew() { return crew; }

    public String getPassengers() { return passengers; }

    public String getCargoCapacity() { return cargoCapacity; }

    public String getConsumables() { return consumables; }

    public String getHyperdriveRating() { return hyperdriveRating; }

    public String getMGLT() { return mGLT; }

    public String getStarshipClass() { return starshipClass; }

    public List<Object> getPilots() { return pilots; }

    public List<String> getFilms() { return films; }

    public String getCreated() { return created; }

    public String getEdited() { return edited; }

    public String getUrl() { return url; }

}
