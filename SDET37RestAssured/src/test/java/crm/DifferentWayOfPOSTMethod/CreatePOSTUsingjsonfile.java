package crm.DifferentWayOfPOSTMethod;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePOSTUsingjsonfile {
	
	@Test
	public void jsonFileImport() {
		
		File file = new File("./src/test/resources/data.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
