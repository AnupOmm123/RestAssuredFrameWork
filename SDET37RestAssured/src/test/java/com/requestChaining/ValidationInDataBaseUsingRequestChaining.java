package com.requestChaining;


import com.crm.genericUtilities.JavaUtility;
import com.genericLibrary.EmployeeJSONobject;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ValidationInDataBaseUsingRequestChaining {
	
	@Test
	public void validatewithDataBase() throws SQLException
	{
		JavaUtility jlib = new JavaUtility();
		EmployeeJSONobject emp = new EmployeeJSONobject("Radhe", "Glucose"+jlib.getRandomNumber(), "Completed", 6);
		
		Response resp= given().body(emp).contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8084/addProject");
		
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().log().all();
		
		given()
		.pathParam("hh", pid)
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:8084/projects/{hh}")
		
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	EmployeeJSONobject emp1 = new EmployeeJSONobject("Rahul", "kkr"+jlib.getRandomNumber(), "On going", 9);
	given()
	.body(emp1)
	.contentType(ContentType.JSON)
	.pathParam("hooo",pid)
	.when()
	.put("http://localhost:8084/projects/{hooo}")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200)
	.log().all();
		given()
		.pathParam("hi",pid)
		.contentType(ContentType.JSON)
		//.pathParam("mm", postdata)
		.when()
	
		.delete("http://localhost:8084/projects/{hi}")
		.then()
		.contentType(ContentType.JSON)
		.assertThat().statusCode(204)
		.log().all();
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		String query = "select* from project";
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			if(pid.equals(result.getString(1)))
					{
				System.out.println("not deleted");
					}
			else
			{
				System.out.println("project is deleted");
				break;
					}
		}
		
				
				
	}

}
