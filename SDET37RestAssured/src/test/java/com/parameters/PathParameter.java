package com.parameters;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void postGet()
	{
		JSONObject job = new JSONObject();
		job.put("createdBy","Ramesh201");
		job.put("projectName","MAriegoldTech");
		job.put("status","Completed");
		job.put("teamSize",5);
		
		Response resp = given().body(job).contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8084/addProject");
				String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		given()
		.pathParams("proidget", pid)
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:8084/projects/{proidget}")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
