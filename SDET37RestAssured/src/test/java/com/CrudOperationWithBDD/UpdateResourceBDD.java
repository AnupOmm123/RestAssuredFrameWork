package com.CrudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateResourceBDD {
	@Test
	public void updateResource() {
		JSONObject jobj = new JSONObject();
		jobj.put( "createdBy","Nandini");
		jobj.put( "projectName","PARle");
		jobj.put( "status","Created");
		jobj.put( "teamSize",9);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1603")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	}

}
