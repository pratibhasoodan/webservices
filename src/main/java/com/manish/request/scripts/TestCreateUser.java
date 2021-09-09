package com.manish.request.scripts;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.manish.request.pojo.CreateUser;
import com.manish.request.services.Services;
import com.manish.response.pojo.CreateUserResponse;


@Test
public class TestCreateUser {
	
	public Response createUserPostAPI(String job ,String name) {
		
		CreateUser request = new CreateUser();
		request.setJob(job);
		request.setName(name);
		JSONObject json = new JSONObject(request);
		List<JSONObject> list = new ArrayList<JSONObject>();
		list.add(json);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json\r\n");
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.body(list.get(0).toString());
		System.out.println(Services.postcreateuser);
		Response response = requestSpecification.post(Services.postcreateuser);
		return response;
	}

	public void createUserPostAPIValidate() {
		
		TestCreateUser createUser = new TestCreateUser();
		//Response response = createUser.createUserPostAPI("leader", "morpheus");
		Response response = createUser.createUserPostAPI("joy", "pratibha");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		if(response.getStatusCode()==201|| response.getStatusCode()==200) {
			Gson gson = new Gson();
			 CreateUserResponse createuserResponse = gson.fromJson(response.asString(),CreateUserResponse.class);
			 String name = createuserResponse.getName();
			 String job = createuserResponse.getJob();
			 Assert.assertEquals(name,"pratibha");
			 Assert.assertEquals(job, "joy");
			
		}
	}
}
