package com.project.webservices.methods;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Put {
	
	@Test
	public void RegistrationSuccessful() throws JSONException
	{		
		int empid=15210;
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	RequestSpecification request =  RestAssured.given();
	
	
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("name", "pratibha");
	requestParams.put("age",30);
	
	
	request.header("Content-Type","application/json");
	request.body(requestParams.toString());
	Response response = request.put("/update/"+empid);
	
	int statuscode = response.getStatusCode();
	Assert.assertEquals(statuscode, "200");
	
		
	}

}
