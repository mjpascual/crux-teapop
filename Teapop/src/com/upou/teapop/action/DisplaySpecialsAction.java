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
		specials = getMockData();
		return SUCCESS;
	}
	
	private Promos getMockData(){
		Promos promos = new Promos();
		
		Promo promo1 = new Promo();
		promo1.setDesc("desc");
		promo1.setImage("free-wifi.jpg");
		promo1.setPromoCode("asddsads");
		promo1.setPromoId(0);
		promo1.setName("Wifi");
		
		Promo promo2 = new Promo();
		promo2.setDesc("desc2");
		promo2.setImage("promo.jpg");
		promo2.setPromoCode("asddsads111");
		promo2.setPromoId(1);
		promo2.setName("Promo!");
		
		
		promos.getPromos().add(promo1);
		promos.getPromos().add(promo2);
		
		return promos;
		
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}

}
