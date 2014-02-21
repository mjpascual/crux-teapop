package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

public class DisplaySpecialsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Promos specials;
	
	public String execute(){
		PromoDao dao = new PromoDao();
//		specials = dao.retrievePromos();
		specials = getMockSPecials();
		return SUCCESS;
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}
	
	private Promos getMockSPecials(){
		Promos specials = new Promos();
		
		Promo promo1 = new Promo();
		promo1.setPromoId(01);
		promo1.setName("name1");
		promo1.setDesc("name1");
		promo1.setImage("name1");
		
		Promo promo2 = new Promo();
		promo2.setPromoId(02);
		promo2.setName("name2");
		promo2.setDesc("name2");
		promo2.setImage("name2");
		
		specials.getPromos().add(promo1);
		specials.getPromos().add(promo2);
		
		return specials;
	}

}
