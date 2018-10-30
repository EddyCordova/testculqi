package com.culqi.bean;

import java.io.Serializable;

public class Number implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer length;
	private boolean luhn;
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public boolean isLuhn() {
		return luhn;
	}
	public void setLuhn(boolean luhn) {
		this.luhn = luhn;
	}
}
