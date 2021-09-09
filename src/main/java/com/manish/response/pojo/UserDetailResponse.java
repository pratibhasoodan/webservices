package com.manish.response.pojo;



	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	public class UserDetailResponse {

	@SerializedName("data")
	@Expose
	private UserDataresponse data;
	@SerializedName("ad")
	@Expose
	private userAdresponse ad;

	public UserDataresponse getData() {
	return data;
	}

	public void setData(UserDataresponse data) {
	this.data = data;
	}

	public userAdresponse getAd() {
	return ad;
	}

	public void setAd(userAdresponse ad) {
	this.ad = ad;
	}

	
}
