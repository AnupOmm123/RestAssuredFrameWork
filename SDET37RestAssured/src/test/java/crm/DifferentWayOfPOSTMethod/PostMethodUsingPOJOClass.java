package crm.DifferentWayOfPOSTMethod;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.genericLibrary.Employee;
import com.genericLibrary.EmployeeJSONobject;

import io.restassured.http.ContentType;

public class PostMethodUsingPOJOClass {
	
	@Test
	public void createObjectUsingPOJOclass()
	{
		EmployeeJSONobject emp = new EmployeeJSONobject("Chitta","Nalco","Completed",9);
		
		given()
		.body(emp)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
