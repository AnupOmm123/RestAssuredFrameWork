package crm.DifferentWayOfPOSTMethod;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericLibrary.EmployeeJSONobject;

import io.restassured.http.ContentType;

public class PostMethodUsingDataprovider {

	@Test(dataProvider="jsondata")
	public void create(String createdBy, String projectName, String status, int teamSize)
	{
		EmployeeJSONobject eobj = new EmployeeJSONobject(createdBy, projectName, status, teamSize);
		
		given()
		.body(eobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
	
	@DataProvider
	public Object[][] jsondata()
	{
		Object[][] ojarr = new Object[4][4];
		ojarr [0][0]="Chunmun";
		ojarr [0][1]="Royalfashion";
		ojarr [0][2]="Completed";
		ojarr [0][3]=3;
		
		ojarr [1][0]="Kunmun";
		ojarr [1][1]="RSTraders";
		ojarr [1][2]="Completed";
		ojarr [1][3]=3;
		
		ojarr [2][0]="Pinu";
		ojarr [2][1]="Construction";
		ojarr [2][2]="Completed";
		ojarr [2][3]=3;
		
		ojarr [3][0]="Bubu";
		ojarr [3][1]="Pharma";
		ojarr [3][2]="Completed";
		ojarr [3][3]=3;
		
		return ojarr;
	}
	
	
}
