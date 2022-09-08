package com.CrudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mysql.cj.log.Log;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonPathJackson1ObjectDeserializer;

public class CreateResourceBDD {
	@Test
	public void CreateResource() {
		
		JSONObject joj = new JSONObject();
		joj.put( "createdBy","ANu");
		joj.put("projectName","NonOffence");
		joj.put("status","On Going");
		joj.put("teamSize",9);
		
		given() // prerequiside
		.contentType(ContentType.JSON)
		.body(joj)
		
		.when()  //action or http method
		.post("http://localhost:8084/addProject")
		
		
		.then() // validation
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
		
		
	}

}
