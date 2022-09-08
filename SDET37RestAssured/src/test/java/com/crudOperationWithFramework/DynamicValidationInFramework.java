package com.crudOperationWithFramework;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.crm.genericUtilities.EndPointLibrary;
import com.crm.genericUtilities.RestAssuredLibrary;


import io.restassured.response.Response;

public class DynamicValidationInFramework {
	
	@Test
	public void validWithFramework() {
		baseURI = "http://localhost";
		port=8084;
		String expdata ="TY_PROJ_608";
	   Response resp = when().get(EndPointLibrary.getAllProjects);
	   
	   
	  // boolean flag = false;
	   RestAssuredLibrary rlib = new RestAssuredLibrary();
	    List<String> pid = rlib.getJsondatas(resp,"projectId");
	    for(String ids : pid)
	    {
	    	if(ids.contentEquals(expdata))
	    	{
	    		//flag=true;
	    		System.out.println("Data is there");
	    	}
	    	//org.testng.Assert.assertTrue(flag);
	    	
	    	
	    	
	    	resp.then().log().all();
	    }
	    
	   
		
		
	}

}
