package com.requestChaining;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;
import com.genericLibrary.EmployeeJSONobject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestChainPostGetPutDelete {

	@Test
	public void allcrudmethod()
	{
		JavaUtility jlib = new JavaUtility();
		EmployeeJSONobject emp = new EmployeeJSONobject("Priya", "electricials"+jlib.getRandomNumber(),"Completed", 8);
		
		Response resp = given()
		.body(emp)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
		
		String pid=resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().log().all();
		
		given()
		.pathParam("hh", pid)
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:8084/projects/{hh}")
		
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	EmployeeJSONobject emp1 = new EmployeeJSONobject("Rahul", "kkr"+jlib.getRandomNumber(), "On going", 9);
	given()
	.body(emp1)
	.contentType(ContentType.JSON)
	.pathParam("hooo",pid)
	.when()
	.put("http://localhost:8084/projects/{hooo}")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200)
	.log().all();
		given()
		.pathParam("hi",pid)
		.contentType(ContentType.JSON)
		//.pathParam("mm", postdata)
		.when()
	
		.delete("http://localhost:8084/projects/{hi}")
		.then()
		.contentType(ContentType.JSON)
		.assertThat().statusCode(204)
		.log().all();
		
		
	}
	
	
}
