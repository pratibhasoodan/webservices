package com.manish.request.scripts;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.manish.request.pojo.RegisterUser;
import com.manish.request.services.Services;
import com.manish.response.pojo.RegisteruserResponse;
import com.manish.response.pojo.UserDetailResponse;

import junit.framework.Assert;

public class Test007 {
	
	@Test
	public Response postRegisterUserAPI(String email, String password) {
	
	RegisterUser request = new RegisterUser();
	request.setEmail(email);
	request.setPassword(password);
	JSONObject json= new JSONObject(request);
	List<JSONObject> list = new ArrayList<JSONObject>();
	list.add(json);
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.contentType("application/json\r\n");
	requestSpecification.accept(ContentType.JSON);
	requestSpecification.body(list.get(0).toString());
	System.out.println(Services.postregisteruser);
	Response response = requestSpecification.post(Services.postregisteruser);
	return response;
	
}
	
	public String getRegisterUserId() {
		String creationId = "";
		Response response =postRegisterUserAPI("eve.holt@reqres.in","pistol");
		System.out.println("response.getStatusCode() "+response.getStatusCode());
		if(response.getStatusCode()==201 || response.getStatusCode() ==200) {
		 Gson gson = new Gson();
		RegisteruserResponse obj = gson.fromJson(response.asString(), RegisteruserResponse.class);
		System.out.println(obj.getId());
		creationId = String.valueOf(obj.getId());
		}
		return creationId;
		   
	}
	
	@Test
	public void validateEmailOfRegisteredUser() {
		String id = getRegisterUserId();
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json\r\n");
		requestSpecification.contentType(ContentType.JSON);
		System.out.println(Services.getuser+"/"+id);
		Response response = requestSpecification.get(Services.getuser+"/"+id);
		System.out.println("response.getStatusCode() "+response.getStatusCode());
		if(response.getStatusCode()==201 || response.getStatusCode() ==200) {
			 Gson gson = new Gson();
			 UserDetailResponse obj = gson.fromJson(response.asString(), UserDetailResponse.class);
			 String email = obj.getData().getEmail();
			 Assert.assertEquals("eve.holt@reqres.in", email);
	}
	
	}
		

	
}
