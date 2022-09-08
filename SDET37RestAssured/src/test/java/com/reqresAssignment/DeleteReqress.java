package com.reqresAssignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteReqress {

	@Test
	public void deleteresorce()
	{
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(204);
	}
	
	
}
