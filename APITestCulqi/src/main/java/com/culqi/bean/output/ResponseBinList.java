package com.culqi.bean.output;

import java.io.Serializable;

import com.culqi.bean.Country;

public class ResponseBinList implements Serializable{

	private static final long serialVersionUID = 1L;
	private com.culqi.bean.Number number;
	private String scheme;
	private String type;
	private String brand;
	private boolean prepaid;
	private Country country;

	public com.culqi.bean.Number getNumber() {
		return number;
	}
	public void setNumber(com.culqi.bean.Number number) {
		this.number = number;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isPrepaid() {
		return prepaid;
	}
	public void setPrepaid(boolean prepaid) {
		this.prepaid = prepaid;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
