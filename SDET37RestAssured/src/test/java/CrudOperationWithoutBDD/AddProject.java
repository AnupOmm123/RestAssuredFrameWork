package CrudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mysql.cj.log.Log;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProject {
	@Test
	public void Create() {
		
		//jasom body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","AnuphSaheoo");
		jobj.put("projectName","fisghTecch1");
		jobj.put("status","Completed");
		jobj.put("teamSize",8);
		
		//preconditions body and content type
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		//actions
		Response response = reqs.post("http://localhost:8084/addProject");
		ValidatableResponse valid = response.then();
		valid.assertThat().statusCode(201);
		valid.assertThat().contentType(ContentType.JSON);
		valid.log().all();
		
		
		
		
		
		
		
		
		
	}

}
