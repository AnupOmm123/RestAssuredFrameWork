package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	public void queryParam()
	{
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users?page")
		.then()
		.log().all();
	}

}
