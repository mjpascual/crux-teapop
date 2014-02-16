package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.SpecialsDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Specials;

public class DisplaySpecialsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Specials specials;
	
	public String execute(){
		SpecialsDao dao = new SpecialsDao();
//		specials = dao.retrievePromos();
		specials = getMockSPecials();
		return SUCCESS;
	}

	public Specials getSpecials() {
		return specials;
	}

	public void setSpecials(Specials specials) {
		this.specials = specials;
	}
	
	private Specials getMockSPecials(){
		Specials specials = new Specials();
		
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
