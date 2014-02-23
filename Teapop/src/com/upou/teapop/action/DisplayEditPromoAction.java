package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;

public class DisplayEditPromoAction extends ActionSupport {
	
	private int promoId;
	
	private String promoDesc;
	
	private String promoCode;
	
	private String promoImage;
	
	private String promoName;
	
	public String editPromo(){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}




	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public String getPromoDesc() {
		return promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoImage() {
		return promoImage;
	}

	public void setPromoImage(String promoImage) {
		this.promoImage = promoImage;
	}
	
	
}
