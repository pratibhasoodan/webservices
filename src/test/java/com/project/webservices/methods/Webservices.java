package com.project.webservices.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Webservices {
	
	public static Response Post(String uRI, String  stringJSON) {
		
RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);	

requestSpecification.contentType(ContentType.JSON);
 Response response =requestSpecification.post(uRI);
return response;
	}
  
	public static Response Get(String uRI) {
		RequestSpecification resquestSpecification = RestAssured.given();
		resquestSpecification.contentType(ContentType.JSON);
		Response response = resquestSpecification.get(uRI);

		return response; 
		
	}
	
	public static Response Put(String uRI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		return response;
		
	}
	
	public static Response Delete(String uRI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		return response;
		
	}
}


