package crm.DifferentWayOfPOSTMethod;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingJSONObject {
	
	@Test
	public void usingJSONobject()
	{
		JSONObject joj = new JSONObject();
		joj.put("createdBy","Anusuya");
		joj.put( "projectName","Realme");
		joj.put( "status","Completed");
		joj.put( "teamSize",8);
		
		given()
		.body(joj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201);
		
	}

}
