package com.spartaglobal.restassured.framework.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RetrieveBodyOrResource {

    private static final String BASEURL = "https://swapi.dev/api/";
    private String body;
    private String resource;

    public String getBody() {
        return body;
    }

    public String getResource() {
        return resource;
    }

    public RetrieveBodyOrResource(String url)
    {
        split(url);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            this.body = response.body();
        } catch (IOException | InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

    public void split(String url)
    {
        String[] brokenUrl = url.replace(BASEURL, "").split("/");
        this.resource = brokenUrl[0];
    }
}
