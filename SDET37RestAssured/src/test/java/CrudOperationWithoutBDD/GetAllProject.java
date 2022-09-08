package CrudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProject {
@Test
public void getAllProject() {
	Response restget = RestAssured.get("http://localhost:8084/projects");
	System.out.println(restget.getContentType());
	System.out.println(restget.getStatusCode());
	System.out.println(restget.getBody());
	
	ValidatableResponse validation = restget.then();
	validation.log().all();
}
}
