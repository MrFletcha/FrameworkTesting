package com.spartaglobal.restassured.framework.types;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spartaglobal.restassured.framework.controller.ValueInjector;

public class Species {

    @JsonProperty("name")
    private String name;
    @JsonProperty("classification")
    private String classification;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("skin_colors")
    private String skinColors;
    @JsonProperty("hair_colors")
    private String hairColors;
    @JsonProperty("eye_colors")
    private String eyeColors;
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("language")
    private String language;
    @JsonProperty("people")
    private List<String> people = null;
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

    public String getClassification() { return classification; }

    public String getDesignation() { return designation; }

    public String getAverageHeight() { return averageHeight; }

    public String getSkinColors() { return skinColors; }

    public String getHairColors() { return hairColors; }

    public String getEyeColors() { return eyeColors; }

    public String getAverageLifespan() { return averageLifespan; }

    public String getHomeworld() { return homeworld; }

    public String getLanguage() { return language; }

    public List<String> getPeople() { return people; }

    public List<String> getFilms() { return films; }

    public String getCreated() { return created; }

    public String getEdited() { return edited; }

    public String getUrl() { return url; }

    public boolean hasPerson(String person)
    {
        arr = getPeople();
        People people;
        for (String s : arr) {
            people = (People) ValueInjector.createDTO(s);
            if (person.equals(people.getName())) {
                System.out.println(people.getName() + " is this species");
                return true;
            }
        }
        System.out.println("No person with this name found in species");
        return false;
    }

    public boolean inFilm(String film)
    {
        arr = getFilms();
        Films films;
        for (String s : arr) {
            films = (Films) ValueInjector.createDTO(s);
            if (film.equals(films.getTitle())) {
                System.out.println("This species is in this Film: " + films.getTitle());
                return true;
            }
        }
        System.out.println("Not in this Film");
        return false;
    }

}
