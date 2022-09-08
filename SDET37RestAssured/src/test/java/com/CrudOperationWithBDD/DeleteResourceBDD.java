package com.CrudOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteResourceBDD {
	@Test
	public void deleteResource() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();
	}

}
