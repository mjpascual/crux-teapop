package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promos;

public class DisplaySpecialsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Promos specials;
	
	public String execute(){
		PromoDao dao = new PromoDao();
		specials = dao.retrievePromos();
		System.out.println(specials.getPromos().get(0).getPromoCode());
		return SUCCESS;
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}

}
