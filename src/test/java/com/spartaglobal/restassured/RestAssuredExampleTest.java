package com.spartaglobal.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import netscape.javascript.JSObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredExampleTest {
	Response response;
	private String url;

	@BeforeEach
	void setup() {
		url = "http://data.fixer.io/api/latest?access_key=2df3aa7f6f154a4e224093c5331dcc40";
		response = RestAssured.get(url);
	}
	
	@Test
	public void statusCodeExampleTest() {
		response.then().assertThat().statusCode(200);
	}

	@Test
	@DisplayName("Testing HTTP version")
	void testingHttpVersion() {
		given().response().when().get(url).then().assertThat().statusCode(200);
	}

	@Test
	@DisplayName("Testing headers")
	void testingHeaders() {
		Assertions.assertEquals("cloudflare", response.getHeader("Server"));
	}

	@Test
	@DisplayName("Body Testing")
	void bodyCheckSuccess()
	{
		response.then().assertThat().body("success", equalTo(true));
		response.then().assertThat().body("rates", hasEntry("EUR", 1));
	}

	@Test
	@DisplayName("BodyCheck values")
	void bodyCheckForValue()
	{
		response.then().assertThat().body("date", Matchers.equalTo(LocalDate.now().toString()));

		//response.then().assertThat().body("timestamp", equalTo(1610529725));
		//when().get(url).then().assertThat().body("timestamp", )
	}

	@Test
	@DisplayName("Counting values of rates")
	void counting()
	{
		HashMap<String, Integer> allRates = response.then().extract().path("rates");
		Assertions.assertEquals(168, allRates.size());
	}

	@Test
	@DisplayName("testing")
	void testName() {
		long timeNow = Instant.now().getEpochSecond();
		//Assertions.assertTrue( < timeNow && ratesPOJO.getTimestamp() > timeNow - 3600);
	}
}
