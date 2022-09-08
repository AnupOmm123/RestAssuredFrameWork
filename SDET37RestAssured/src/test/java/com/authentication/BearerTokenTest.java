package com.authentication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BearerTokenTest {
	
	@Test
	public void authenticationBearerToken() {
		baseURI="https://api.github.com";
		JSONObject job = new JSONObject();
		job.put("name", "sdet37restAssured");
		
		given()
			.auth()
			.oauth2("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")
			.body(job)
		.when()
			.get("/user/repos")
		.then()
			.assertThat().log().all();
	}

}
