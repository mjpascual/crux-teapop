package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;

public class AddPromoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Promo promo;
	
	public String addPromo(){
		
		PromoDao dao = new PromoDao();
		if(promo.getImage() == null){
			promo.setImage("default.png");
		}
		if(dao.createPromo(promo)){
			return SUCCESS;
		} else {
			return "FAILED";
		}
	}

	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}
	
	
}
