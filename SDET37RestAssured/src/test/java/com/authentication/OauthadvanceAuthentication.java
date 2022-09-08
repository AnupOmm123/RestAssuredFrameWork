package com.authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OauthadvanceAuthentication {
	
	@Test
	public void oauthAuthentication()
	{
		Response resp = given().formParam("client_id","AnupOmmRestApi")
		.formParam("client_secret","4ed9d963a267fce41fd85bbb4e4d9754")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","https://demodesk:8084")
		.formParam("code","3750")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token = resp.jsonPath().get("access_token");
		
		System.out.println(token);

//		given()
//			.auth().oauth2(token)
//			.pathParam("new token", 3750)
//		.when()
//			.post("http://coop.apps.symfonycasts.com/api/{new token}/barn-unlock")
//		.then()
//			.log().all();
//		
//		given()
//		.auth().oauth2(token)
//		.pathParam("tokenid",3750)
//		.when()
//		.post("http://coop.apps.symfonycasts.com/api/{tokenid}/toiletseat-down")
//		.then()
//		.log().all();

//		given()
//		.auth().oauth2(token)
//		.pathParam("uid",3750)
//		.when()
//		.post("http://coop.apps.symfonycasts.com/api/{uid}/eggs-collect")
//		.then().log().all();
		
		given()
		.auth().oauth2(token)
		.pathParam("uidref",3750)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{uidref}/eggs-count")
		.then()
		.log().all();
		
	

	
	}
	

}
