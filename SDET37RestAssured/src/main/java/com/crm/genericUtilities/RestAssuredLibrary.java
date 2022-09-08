package com.crm.genericUtilities;

import java.util.List;

import io.restassured.response.Response;
/**
 * this class contains rest assured specific reusable methods
 * @author Anupam
 *
 */



public class RestAssuredLibrary {
	/**
	 * this method will get the json data through json path from response body
	 * @param response
	 * @param path
	 * @return
	 */
	public String getJsonData(Response response, String path)
	{
		String jsondata = response.jsonPath().get(path);
		return jsondata;
	}
	
	public List<String> getJsondatas(Response response, String path)
	{
		List<String> jsondata = response.jsonPath().get(path);
		return jsondata;
	}
	

}
