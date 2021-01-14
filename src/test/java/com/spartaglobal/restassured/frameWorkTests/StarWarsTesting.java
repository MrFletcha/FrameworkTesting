package com.spartaglobal.restassured.frameWorkTests;

import com.spartaglobal.restassured.framework.controller.ConnectionManager;
import com.spartaglobal.restassured.framework.controller.ValueExists;
import com.spartaglobal.restassured.framework.controller.ValueInjector;
import com.spartaglobal.restassured.framework.types.People;
import com.spartaglobal.restassured.framework.types.Planets;
import com.spartaglobal.restassured.framework.types.Starship;
import org.junit.jupiter.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.given;

public class StarWarsTesting {
    ConnectionManager connectionManager = new ConnectionManager();
    People people;
    private String url;

    @BeforeEach
    @DisplayName("Setting Up Connection")
    void setUp()
    {
        url = "https://swapi.dev/api/people/1/";
        connectionManager.setUrl(url);
        connectionManager.setResource(url);
    }

    @Test
    @DisplayName("Connection status")
    void connectionStatus() {
        given().get(url).then().assertThat().statusCode(200).and()
                .header("Server", Matchers.equalTo("nginx/1.16.1"));
        Assertions.assertEquals(200, connectionManager.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://swapi.dev/api/people/1/", "http://swapi.dev/api/planets/1/"})
    @DisplayName("Error codes on incorrect url")
    void errorCodeCheck(String url)
    {
        Assertions.assertEquals(301, connectionManager.isValidAddress(url));
    }

    @ParameterizedTest(name = "{index}")
    @ValueSource(strings = {"https://swapi.dev/api/people/1/", "https://swapi.dev/api/planets/1/", "https://swapi.dev/api/starships/12/"})
    @DisplayName("Object Test")
    void objectTest(String urlTypes) {

        Assertions.assertEquals(200,  connectionManager.isValidAddress(urlTypes));
        Object temp = ValueInjector.createDTO(urlTypes);
        String name = temp.getClass().getSimpleName();
        if(name.equals("people"))
        {
            Assertions.assertEquals("People", temp.getClass().getSimpleName());
            given().get(urlTypes).then().assertThat().body("name", Matchers.equalTo(((People) temp).getName()));
        }
        if(name.equals("planets"))
        {
            Assertions.assertEquals("Planets", temp.getClass().getSimpleName());
            given().get(urlTypes).then().assertThat().body("name", Matchers.equalTo(((Planets) temp).getName()));
        }
        if(name.equals("starships"))
        {
            Assertions.assertEquals("Starships", temp.getClass().getSimpleName());
            Assertions.assertEquals("x-wing", (((Starship) temp).getName()));
            given().get(urlTypes).then().assertThat().body("name", Matchers.equalTo(((Starship) temp).getName()));
        }
    }

    @Test
    @DisplayName("Testing DTO")
    void testingDto() {
        people = (People) ValueInjector.createDTO(url);
        given().get(url).then().assertThat().body("name", Matchers.equalTo(people.getName()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"starships", "planets"})
    @DisplayName("Testing Object Arrays")
    void testingObjectsArrays(String arrayType) {

        People people = (People) ValueInjector.createDTO(url);

        if(arrayType.equals("starships")) {
            //This needs to be added into each array as a http value us given instead of https
            Starship starship = (Starship)
                    ValueInjector.createDTO(people.getStarships().get(0));

            Assertions.assertEquals(people.getName() + " is a Pilot", starship.hasPilot(people.getName()));

            given().get(people.getStarships().get(0)).then().assertThat()
                    .body("name", Matchers.equalTo(starship.getName()));
        }
        else if(arrayType.equals("planets"))
        {
            Planets planets = (Planets)
                    ValueInjector.createDTO(people.getHomeworld());

            Assertions.assertEquals(people.getName() + " is a Resident", planets.hasResidents(people.getName()));

            given().get(people.getHomeworld()).then().assertThat()
                    .body("name", Matchers.equalTo(planets.getName()));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"X-wing", "Imperial shuttle"})
    @DisplayName("Search Test")
    void searchTest(String ship)
    {
        people = (People) ValueInjector.createDTO(url);
        Assertions.assertEquals("Has this Starship: " + ship, people.hasShip(ship));
        Assertions.assertEquals("No starship with this name found", people.hasShip("falcon"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"X-wing", "Imperial shuttle"})
    @DisplayName("Value exists class")
    void valueExistsClass(String ship)
    {
        Assertions.assertTrue(ValueExists.isStarshipByName(ship));
        Assertions.assertFalse(ValueExists.isStarshipByName("X-"));
        Assertions.assertTrue(ValueExists.isPersonByName("Luke Skywalker"));
        Assertions.assertTrue(ValueExists.isPlanetByName("Tatooine"));
        Assertions.assertFalse(ValueExists.isPlanetByName("Pluto"));
        Assertions.assertTrue(ValueExists.isFilmByTitle("A New Hope"));
        Assertions.assertTrue(ValueExists.isVehicleByName("Sand Crawler"));
        Assertions.assertTrue(ValueExists.isSpeciesByName("Human"));
    }
}
