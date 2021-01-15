package com.spartaglobal.restassured.framework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ConnectionManager {

    private static final String BASEURL = "https://swapi.dev/api/";
    private String resource;
    private HttpResponse<String> response;
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    //can be used check if the resource is being collected correctly
    public String getResource() {
        return resource;
    }

    //finds out if the url is null
    public String getUrl() {
        return url;
    }

    public void setResource(String url) {
       this.resource = url.replace(BASEURL,"");
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public int getStatusCode()
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        int statusCode = 0;
        try{
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            statusCode = response.statusCode();
        } catch (IOException | InterruptedException ex)
        {
            ex.printStackTrace();
        }
        return statusCode;
    }

    public int isValidAddress(String url)
    {
        setUrl(url);
        Map<Integer, String> result = new HashMap<>();
        try {
            result = new ObjectMapper().readValue(new File("src/test/resources/ErrorCode.json"), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(getStatusCode() != 200)
        {
            System.err.println("The url address of " + url + " is not valid, please check following description of error code: ");
        }

        System.err.println("Status code: " + getStatusCode() + " Code Description: " + result.get(String.valueOf(getStatusCode())) +"\n");
        return getStatusCode();
    }

    public String headerCheck(String header)
    {
        String headerValue = given().get(url).then().extract().header(header);
        if(headerValue == null) { return "null"; }
        System.out.println("The header you searched for has a value of: " + headerValue);
        return headerValue;
    }
}
