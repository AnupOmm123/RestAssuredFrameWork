package com.validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidation {
	
	@Test
	public void dynamicobjectValidation()
	{
		String exppid="TY_PROJ_207";
		Response resp = when().get("http://localhost:8084/projects");
		
		boolean flag = false;
		List<String> pids = resp.jsonPath().get("projectId");
		for(String eid:pids)
		{
			if(eid.equalsIgnoreCase(exppid))
			{
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		
		resp.then().log().all();
		
		
	}

}
