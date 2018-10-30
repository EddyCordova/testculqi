package com.culqi.bean.output;

import java.io.Serializable;

public class ResponseGenerarToken implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	private String brand;
	private String creation_dt;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCreation_dt() {
		return creation_dt;
	}
	public void setCreation_dt(String creation_dt) {
		this.creation_dt = creation_dt;
	}
	
	

}
