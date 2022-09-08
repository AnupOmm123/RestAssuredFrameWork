package com.authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DigestiveAuth {
	
	@Test
	public void digesstiveAuth() {
		given()
		.auth().digest("rmgyantra","rmgy@9999")
		.when()
	 .get("http://localhost:8084/login")
	 .then()
	 .assertThat().log().all();
		
	}

}
