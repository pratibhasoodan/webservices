package com.project.utilis;

public enum EndPointURL {
	
	ADD_COUNTRY("/countries/details"),
	UPDATE_COUNTRY("/countries/update/details"),
	GET_COUNTRY_BY_ID("/country"),
	DELETE_COUNTRY("/country"),
	GET_COUNTRIES("/countries");
	
	String resourcePath;
	
	EndPointURL(String resourcePath){
		this.resourcePath = resourcePath;
		
	}
	
	public String getResourcePath() {
		
		return this.resourcePath;
	}
	
public String getResourcePath(String data ) {
		
		return this.resourcePath+data;
	}

public static void main(String[] args) {
	
	System.out.println("making endpoint url");
	System.out.println(EndPointURL.ADD_COUNTRY.getResourcePath());
	
	
	System.out.println("making full url");
	String url=URL.fixURL1+EndPointURL.ADD_COUNTRY.getResourcePath();
	
	System.out.println(url);
	
	
}

}
