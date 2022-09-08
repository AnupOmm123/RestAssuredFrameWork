package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class pathparamnew {
	
	@Test
	public void pathhhparammm()
	{
		baseURI="http://localhost";
		port=8080;
		
		given()
		.pathParam("proid","ty_proj_003")
		.contentType(ContentType.JSON)
		.when()
		.get("/{proid}")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
