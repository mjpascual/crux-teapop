package com.upou.teapop.data;

public class Price {
	
	private String currency;

	private double small;
	
	private double regular;

	private double large;
	
	public double getRegular() {
		return regular;
	}

	public void setRegular(double regular) {
		this.regular = regular;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public double getSmall() {
		return small;
	}

	public void setSmall(double small) {
		this.small = small;
	}

	public double getLarge() {
		return large;
	}

	public void setLarge(double large) {
		this.large = large;
	}

	

}
