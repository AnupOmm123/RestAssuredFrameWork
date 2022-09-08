package com.reqresAssignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.genericLibrary.ReqresPOJOclass;

import io.restassured.http.ContentType;

public class PutReqress {
	
	@Test
	public void putreqress()
	{
		ReqresPOJOclass rpoj = new ReqresPOJOclass("Mahabir","Sales");
	
		given()
		.body(rpoj)
		.contentType(ContentType.JSON)
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

}
