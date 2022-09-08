package crm.DifferentWayOfPOSTMethod;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class createthroughcsvfile {
	
	@Test
	public void csvpost() {
		File csv = new File("/src/test/resources/newone.xlsx");
		
given()
.body(csv)
.contentType(ContentType.JSON)
.when()
.post("http://localhost:8084/addProject")
.then()
.log().all();
		
	}

}
