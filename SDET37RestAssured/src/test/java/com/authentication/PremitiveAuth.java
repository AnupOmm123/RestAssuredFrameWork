package com.authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PremitiveAuth {
	
	@Test
	public void premitiveeAuthent()
	{
		given()
		.auth().preemptive().basic("rmgyantra","rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat().log().all();
		
	}

}
