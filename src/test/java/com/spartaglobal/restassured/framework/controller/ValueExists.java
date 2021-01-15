package com.spartaglobal.restassured.framework.controller;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class ValueExists {

    public static boolean isStarshipByName(String ship) {
        if (isNull(ship)) {
            return false;
        }
        ArrayList<String> allShips = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            allShips.addAll(given().get("https://swapi.dev/api/starships/?page=" + i).then().extract().path("results.name"));
        }
        System.out.println("The current total count of all ships is: " + allShips.size() + " over five pages.");
        return allShips.contains(ship);
    }

    public static boolean isPersonByName(String person) {
        if (isNull(person)) {
            return false;
        }

        ArrayList<String> allPeople = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            allPeople.addAll(given().get("https://swapi.dev/api/people/?page=" + i).then().extract().path("results.name"));
        }
        System.out.println("The current total count of people is : " + allPeople.size() + " over ten pages.");
        return (allPeople.contains(person));
    }

    public static boolean isPlanetByName(String planet) {
        if (isNull(planet)) {
            return false;
        }

        ArrayList<String> allPlanets = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            allPlanets.addAll(given().get("https://swapi.dev/api/planets/?page=" + i)
                    .then().extract().path("results.name"));
        }
        System.out.println("The current total count of Planets is: " + allPlanets.size() + " over seven pages.");
        return allPlanets.contains(planet);
    }

    public static boolean isFilmByTitle(String film) {
        if (isNull(film)) {
            return false;
        }
        ArrayList<String> allFilms = new ArrayList<>();
        allFilms.addAll(given().get("https://swapi.dev/api/films/?page=1")
                .then().extract().path("results.title"));
        System.out.println("The current total count of Films is: " + allFilms.size() + " over one page");
        return allFilms.contains(film);
    }

    public static boolean isSpeciesByName(String species) {
        if (isNull(species)) {
            return false;
        }
        ArrayList<String> allSpecies = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            allSpecies.addAll(given().get("https://swapi.dev/api/species/?page=" + i)
                    .then().extract().path("results.name"));
        }
        System.out.println("The current count of Species is: " + allSpecies.size() + " over five pages.");
        return allSpecies.contains(species);
    }

    public static boolean isVehicleByName(String vehicle) {
        if (isNull(vehicle)) {
            return false;
        }

        ArrayList<String> allVehicles = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            allVehicles.addAll(given().get("https://swapi.dev/api/vehicles/?page=" + i)
                    .then().extract().path("results.name"));
        }
        System.out.println("The current count of Vehicles is: " + allVehicles.size() + " over five pages.");
        return allVehicles.contains(vehicle);
    }

    public static Set<String> allBirthYears()
    {
        Set<String> birthRecord = new HashSet<>();
        for(int i = 0; i < 10; i++)
        {
            birthRecord.addAll(given().get("https://swapi.dev/api/people").then().extract().path("results.birth_year"));
        }
        return birthRecord;
    }

    static boolean isNull(String string) {
        return (string == null || string.equals(""));
    }
}
