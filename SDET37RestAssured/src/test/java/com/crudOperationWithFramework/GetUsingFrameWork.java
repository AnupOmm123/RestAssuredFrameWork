package com.crudOperationWithFramework;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointLibrary;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.RestAssuredLibrary;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUsingFrameWork {
	
	@Test
	public void getAndPut()
	{
		JavaUtility jlib = new JavaUtility();
		RestAssuredLibrary rlib = new RestAssuredLibrary();
		
		
		ProjectLibrary plib = new ProjectLibrary("Rehman", "rmghjjk"+jlib.getRandomNumber(), "Completed", 9);
		Response resp = given().contentType(ContentType.JSON)
		.when().get(EndPointLibrary.getAllProjects);
		resp.then().assertThat().statusCode(200);
		
		String pids = rlib.getJsonData(resp, "TY_PROJ_1603");
		
		
		given().body(plib)
		.contentType(ContentType.JSON)
		.pathParam("ids", pids)
		.when()
		.put(EndPointLibrary.updateProject+"{ids}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	

}
