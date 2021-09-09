package com.project.webservices.methods;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Post {
	
	@Test
	public void RegistrationSuccessful() throws JSONException
	{		
		//Step 1: Create a Request pointing to the Service Endpoint
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		/*Step 2: Create a JSON request which contains all the fields
		JSONObject is a class that represents a Simple JSON.
		 We can add Key - Value pairs using the put method
*/
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		
		
		//Step 3: Add JSON body in the request and send the Request
		// Add a header stating the Request body is a JSON
		
		
		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.post("/register");
		
		//Step 4: Validate the Response
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
}