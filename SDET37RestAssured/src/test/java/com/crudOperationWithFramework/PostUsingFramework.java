package com.crudOperationWithFramework;

import com.crm.genericUtilities.BaseApiClass;
import com.crm.genericUtilities.EndPointLibrary;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.RestAssuredLibrary;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PostUsingFramework {
	@Test
	public void postFramework()
	{
//		BaseApiClass baselib = new BaseApiClass();
//		baselib.dbbsconfig();
		
		
		JavaUtility jlib = new JavaUtility();
		ProjectLibrary plib = new ProjectLibrary("Jerry", "lifesolutions"+jlib.getRandomNumber(), "Completed", 8);
		 baseURI="http://localhost";
		 port=8084;
		 
		
		Response resp = given()
							.body(plib)
							.contentType(ContentType.JSON)
						.when()
							.post(EndPointLibrary.createProject);
		
		RestAssuredLibrary rlib = new RestAssuredLibrary();
		String pid = rlib.getJsonData(resp,"projectId");
		System.out.println(pid);
					resp.then()
							.assertThat().log().all();
					
					given()
						.pathParam("proid", pid)
						.contentType(ContentType.JSON)
					.when()
						.get(EndPointLibrary.getSingleProject+"{proid}")
						.then()
						.assertThat().statusCode(200)
						.log().all();
					
					
					
					
				
	}

}
