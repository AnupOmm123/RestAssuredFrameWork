package com.requestChaining;


import com.crm.genericUtilities.JavaUtility;
import com.genericLibrary.EmployeeJSONobject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RequestChainPostPut {

 @Test
 public void rqstpostput() {
	 
	 JavaUtility joj = new JavaUtility();
	 EmployeeJSONobject emp = new EmployeeJSONobject("narayan", "sweets"+joj.getRandomNumber(), "Completed", 9);
	 
	 Response resp = given().body(emp).contentType(ContentType.JSON)
	 .when()
	 .post("http://localhost:8084/addProject");
	 
	 String pid = resp.jsonPath().get("projectId");
	 System.out.println(pid);
	 resp.then().log().all();
	 
	 EmployeeJSONobject emp1 = new EmployeeJSONobject("Murti", "Kesri"+joj.getRandomNumber(), "On Going", 6);
	// JSONObject jobj = new JSONObject();
	// jobj.put("projectName","Tigerrrrr");
	 given()
	 .pathParam("ProId", pid)
	.contentType(ContentType.JSON)
	.body(emp1)
	 .when()
	 .put("http://localhost:8084/projects/{ProId}")
	 .then()
	.assertThat().statusCode(200)
  .assertThat().contentType(ContentType.JSON)
	 .log().all();

 }
	
	
}
