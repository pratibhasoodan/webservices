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
import com.manish.request.pojo.CreateUser;
import com.manish.request.services.Services;
import com.manish.response.pojo.RegisteruserResponse;

public class Test005 {
	
	@Test 
	public Response getResponseDetail(String name,  String job) {
		
		CreateUser request = new CreateUser();
		request.setJob(job);
		request.setName(name);
		
		JSONObject object = new JSONObject(request);
		List<JSONObject> list = new ArrayList<JSONObject>();
		
		 RequestSpecification requestspecification = RestAssured.given();
		 requestspecification.contentType("\"application/Json\"");
		 requestspecification.accept(ContentType.JSON);
		 requestspecification.body(list.get(0).toString());
		 System.out.println(Services.postcreateuser);
		Response response = requestspecification.put(Services.postcreateuser);
		return response;
		
	}
	
	public String getRegisteredUserId() {
		

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
}
