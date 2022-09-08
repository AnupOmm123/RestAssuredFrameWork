package com.reqresAssignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Reqresget {
	
	@Test
	public void getdata()
	{
	given()
	.contentType(ContentType.JSON)
	.when()
	.get("https://reqres.in/api/users/2")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200)
	.log().all();
	}

}
