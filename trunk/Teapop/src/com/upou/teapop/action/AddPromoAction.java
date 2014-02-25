package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

public class AddPromoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Promo promo;
	private Promos specials;
	
	
	public String execute(){
		
		PromoDao dao = new PromoDao();
		try {
			if(promo.getImage() == null){
				promo.setImage("default.png");
			}
			
			if(!promo.getName().isEmpty() && !promo.getDesc().isEmpty()){
				if(dao.createPromo(promo)){
					addActionMessage(promo.getName() + DisplayConstants.ADD_SUCCESS);
				} else {
					addActionError("Promo " + promo.getName() + " Add Failed");
				}
			} else {
				addActionError("Promo " + promo.getName() + " Add Failed");
			}
			
		} catch (Exception e) {
			return ERROR;
		}
		
		specials = dao.retrievePromos();
		return SUCCESS;
	}
	
	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}
	
	

}
