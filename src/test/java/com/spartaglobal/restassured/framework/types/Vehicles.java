package com.spartaglobal.restassured.framework.types;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spartaglobal.restassured.framework.controller.ValueInjector;

public class Vehicles {

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
    @JsonProperty("vehicle_class")
    private String vehicleClass;
    @JsonProperty("pilots")
    private List<String> pilots = null;
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

    public String getModel() { return model; }

    public String getManufacturer() { return manufacturer; }

    public String getCostInCredits() { return costInCredits; }

    public String getLength() { return length; }

    public String getMaxAtmospheringSpeed() { return maxAtmospheringSpeed; }

    public String getCrew() { return crew; }

    public String getPassengers() { return passengers; }

    public String getCargoCapacity() { return cargoCapacity; }

    public String getConsumables() { return consumables; }

    public String getVehicleClass() { return vehicleClass; }

    public List<String> getPilots() { return pilots; }

    public List<String> getFilms() { return films; }

    public String getCreated() { return created; }

    public String getEdited() { return edited; }

    public String getUrl() { return url; }

    public boolean hasPilot(String person)
    {
        arr = getPilots();
        People people;
        for (String s : arr) {
            people = (People) ValueInjector.createDTO(s);
            if (person.equals(people.getName())) {
                System.out.println(people.getName() + " is a Pilot");
                return true;
            }
        }
        System.out.println("No Pilot with this name found");
        return false;
    }

    public boolean inFilm(String film)
    {
        arr = getFilms();
        Films films;
        for (String s : arr) {
            films = (Films) ValueInjector.createDTO(s);
            if (film.equals(films.getTitle())) {
                System.out.println("Is in this Film: " + films.getTitle());
                return true;
            }
        }
        System.out.println("Not in this Film");
        return false;
    }
}
