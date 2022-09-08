package CrudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutOneProject {
	@Test
	public void putproject() {
		//jason object
		JSONObject jobj1 = new JSONObject();
		jobj1.put( "createdBy","NATHANN");
		jobj1.put( "projectName","BIRLA");
		jobj1.put("status", "On Going");
		jobj1.put("teamSize", 11);
		
 RequestSpecification rput = RestAssured.given();
		rput.body(jobj1);
		rput.contentType(ContentType.JSON);
		
		Response respo = rput.put("http://localhost:8084/projects/TY_PROJ_006");
		ValidatableResponse validate2 = respo.then();
		validate2.assertThat().statusCode(200);
		validate2.assertThat().contentType(ContentType.JSON);
		
	}

}
