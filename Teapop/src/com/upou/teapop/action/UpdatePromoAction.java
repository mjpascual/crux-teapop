package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

public class UpdatePromoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Promo promo;
	private Promos specials;
	
	public String execute(){
		PromoDao dao = new PromoDao();
		System.out.println("UPDATING PROMO");
		try {
			if(!promo.getName().isEmpty() && !promo.getDesc().isEmpty() && promo.getPromoId() > 0){
				if(dao.editPromo(promo)){
					addActionMessage("Promo #" + promo.getPromoId() + DisplayConstants.UPDATE_SUCCESS);
				} else {
					addActionError("Failed to Update Promo #" + promo.getPromoId());
				}
				
			} else {
				addActionError("Failed to Update Promo #" + promo.getPromoId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
