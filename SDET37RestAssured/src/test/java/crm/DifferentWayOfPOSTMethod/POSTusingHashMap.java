package crm.DifferentWayOfPOSTMethod;

import java.util.HashMap;

import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class POSTusingHashMap {
	
	@Test
	public void postusingHashMap() {
		
		HashMap h = new HashMap();
		h.put( "createdBy","Akruti");
		h.put( "projectName","Hitachi");
		h.put("status","Completed");
		h.put( "teamSize",7);
		
		given()
		.body(h)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();

}
}
