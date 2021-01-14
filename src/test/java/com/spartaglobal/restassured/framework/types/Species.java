package com.spartaglobal.restassured.framework.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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

}
