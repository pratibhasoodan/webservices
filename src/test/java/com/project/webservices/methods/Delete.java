package com.project.webservices.methods;

import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import junit.framework.Assert;

public class Delete {
	
	public void RegistratiomSuccessful() throws JSONException {
		
		int empid=1542;
		
		RestAssured.baseURI="httsp";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams =new JSONObject();
		requestParams.put("name","pratibha");
		
		
		request.header("Content-Type","application/Json");
		request.body(requestParams.toString());
		Response response = request.delete("/delete/"+empid);
		
		int statuscode =  response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	
	String jsonString =response.asString();
	 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	 }

}
