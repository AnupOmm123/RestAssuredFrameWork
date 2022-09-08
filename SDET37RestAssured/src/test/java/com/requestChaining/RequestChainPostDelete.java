package com.requestChaining;


import com.crm.genericUtilities.JavaUtility;
import com.genericLibrary.EmployeeJSONobject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class RequestChainPostDelete {

	@Test
	public void rqstchainnDeletePost() {
		
		JavaUtility jlib = new JavaUtility();
		EmployeeJSONobject emp= new EmployeeJSONobject("Hatim", "Ceat"+jlib.getRandomNumber(), "Completed", 7);
	 Response resp = given().body(emp).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
	 
	 String pid = resp.jsonPath().get("projectId");
	 System.out.println(pid);
	 resp.then().log().all();
	 
	 given()
	 .pathParam("projectid", pid)
	 .when()
	 .delete("http://localhost:8084/projects/{projectid}")
	 .then()
	 .assertThat().statusCode(204)
	 .log().all();
	
	
		
	}
	
	
}
