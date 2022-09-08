package com.requestChaining;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestChainGetDelete {
	
	@Test
	public void getDeleteRqstChain()
	{
Response resp = given().contentType(ContentType.JSON)
.when()
.get("http://localhost:8084/projects");

String pid = resp.jsonPath().get("[0].projectId");
System.out.println(pid);
resp.then().log().all();

given()
.pathParam("proid", pid)
.when()
.delete("http://localhost:8084/projects/{proid}")
.then()
.assertThat().statusCode(204);
	}}

	


