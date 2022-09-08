package com.validation;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticValidation {
	
	@Test
	public void staticValidation()
	{
	
		String expecteddata ="ty_proj_003";
		Response response = when().get("http://localhost:8084/projects");
	 String actdata = response.jsonPath().get("[0].projectId");
		//System.out.println(actdata);
		
//		response.then().assertThat().statusCode(200)
//	.assertThat().contentType(ContentType.JSON)
//	.log().all();
//		
		Assert.assertEquals(actdata,expecteddata);
		System.out.println("data verified");
		response.then().log().all();
		
	}

}
