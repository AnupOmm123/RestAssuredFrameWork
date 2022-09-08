package com.reqresAssignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.genericLibrary.ReqresPOJOclass;

import io.restassured.http.ContentType;

public class AddProjectVerifyDataBase {
	
	@Test
	public void projectofReqress()
	{
		ReqresPOJOclass rpj = new ReqresPOJOclass("Panda" , "Doctor");
		
		given()
		.body(rpj)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
		
		
	}

}
