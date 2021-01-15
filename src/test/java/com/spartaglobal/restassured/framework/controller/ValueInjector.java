package com.spartaglobal.restassured.framework.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.restassured.framework.types.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueInjector {

    static RetrieveBodyOrResource bodyCheck;
    static Object object;
    static ObjectMapper objectMapper = new ObjectMapper();
    private static String resource = "";

    public static String whichObject(String string) {
        Pattern pattern = Pattern.compile("(https)");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.find()) {
            string = string.replaceFirst("p", "ps");
        }
        bodyCheck = new RetrieveBodyOrResource(string);
        resource = bodyCheck.getResource();
        return bodyCheck.getResource();
    }

    public static Object createDTO(String url) {
        object = null;
        if (isNull(url)) {
            System.out.println("Your url is null.");
            return object; }

        String resource = whichObject(url);
        switch (resource) {
            case "people":
                try {
                    object = objectMapper.readValue(bodyCheck.getBody(), People.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "planets":
                try {
                    object = objectMapper.readValue(bodyCheck.getBody(), Planets.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "starships":
                try {
                    object = objectMapper.readValue(bodyCheck.getBody(), Starship.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "species":
                try {
                    object = objectMapper.readValue(bodyCheck.getBody(), Species.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "vehicles":
                try {
                    object = objectMapper.readValue(bodyCheck.getBody(), Vehicles.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "films":
                try {
                    object = objectMapper.readValue(bodyCheck.getBody(), Films.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
        return object;
    }

    static boolean isNull(String string) {
        return (string == null || string.equals(""));
    }
}