package com.project.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.project.utilis.EndPointURL;
import com.project.utilis.URL;
import com.project.webservices.methods.Webservices;

public class TC_001 {
	
Response response;
	
	@BeforeClass
	
	public void setup() {
		
	}
	
	@Test
	
	public void verifygetCountries() {
		
		String url = URL.fixURL1+EndPointURL.ADD_COUNTRY.getResourcePath();
		response = Webservices.Get(url);
		System.out.println(response.getBody().asString());
	}
	
	@Test
	
	public void verifyCountriesById() {
		
		String url = URL.fixURL1+EndPointURL.ADD_COUNTRY.getResourcePath("1");
		response=Webservices.Get(url);
		System.out.println(response.getBody().asString());
		
	}

}
