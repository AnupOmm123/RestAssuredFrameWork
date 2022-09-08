package com.requestChaining;


import com.crm.genericUtilities.JavaUtility;
import com.genericLibrary.EmployeeJSONobject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

public class RequestChainPostGet {
	
	@Test
	public void rqstchainPostGet() {
		
		JavaUtility joj = new JavaUtility();
		EmployeeJSONobject eobj = new EmployeeJSONobject("Rohit", "Mrf"+joj.getRandomNumber(), "On Going", 9);
		
		Response resp = given()
		.body(eobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
		
		String proid = resp.jsonPath().get("projectId");
		System.out.println(proid);
		resp.then().log().all();
		
		given()
		.pathParam("ProjectId", proid)
		.when()
		.get("http://localhost:8084/projects/{ProjectId}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
				
		
		
	}

}
