package com.manish.request.scripts;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.manish.request.pojo.RegisterUser;
import com.manish.request.services.Services;
import com.manish.response.pojo.CreateUserResponse;
import com.manish.response.pojo.RegisteruserResponse;
import com.manish.response.pojo.UserDetailResponse;


@Test
public class Test006 {
	
	public Response postUserAPI(String email, String password) {
		
		RegisterUser request = new RegisterUser();
		request.setEmail(email);
		request.setPassword(password);
		
		JSONObject json = new JSONObject(request);
		List<JSONObject> list = new ArrayList<JSONObject>();
		list.add(json);
		
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType("application/json\r\n");
		requestspecification.accept(ContentType.JSON);
		requestspecification.body(list.get(0).toString());
		System.out.println(Services.postregisteruser);
		Response response = requestspecification.post(Services.postregisteruser);
		return response;
}
	
	public String getRegisterUserId() {
		
		
		String creationId = "";
		Test006 createUser = new Test006();
		//Response response = createUser.postUserAPI("leader", "morpheus");
		Response response = createUser.postUserAPI("eve.holt@reqres.in","pistol");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		if(response.getStatusCode()==201|| response.getStatusCode()==200) {
			Gson gson = new Gson();
			RegisteruserResponse obj = gson.fromJson(response.asString(),RegisteruserResponse.class);
			System.out.println(obj.getId());
			creationId = String.valueOf(obj.getId());
	}
		return creationId;
	
}
	
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

