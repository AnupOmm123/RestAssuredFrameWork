package CrudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProject {
	@Test
	public void delete() {
		
		
		Response rdel = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1002");
		ValidatableResponse valdelete = rdel.then();
		valdelete.assertThat().statusCode(204);
		
	}

}
