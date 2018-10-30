package com.culqi.bean.input;

import java.io.Serializable;

public class RequestGenerarToken implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String pan;
	private String exp_year;
	private Integer exp_month;
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getExp_year() {
		return exp_year;
	}
	public void setExp_year(String exp_year) {
		this.exp_year = exp_year;
	}
	public Integer getExp_month() {
		return exp_month;
	}
	public void setExp_month(Integer exp_month) {
		this.exp_month = exp_month;
	}
	
	
}
