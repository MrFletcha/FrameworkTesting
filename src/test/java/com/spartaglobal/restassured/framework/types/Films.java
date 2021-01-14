package com.spartaglobal.restassured.framework.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
