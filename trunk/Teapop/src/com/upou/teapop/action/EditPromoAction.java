package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

/**
 * @author TimJosef
 *
 */
public class EditPromoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Promo promo;
	private Promos specials;
	private boolean editSuccessful;
	private boolean editFailed;
	
	public String editPromo(){
		PromoDao dao = new PromoDao();
		System.out.println(promo.getPromoId());
		if(!promo.getName().isEmpty() && !promo.getDesc().isEmpty() && promo.getPromoId() > 0){
			if(dao.editPromo(promo)){
				editSuccessful = true;
				specials = dao.retrievePromos();
			} else {
				editFailed = true;
			}
		} else {
			editFailed = true;
		}
		
		return SUCCESS;
	}

	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public boolean isEditSuccessful() {
		return editSuccessful;
	}

	public void setEditSuccessful(boolean editSuccessful) {
		this.editSuccessful = editSuccessful;
	}

	public boolean isEditFailed() {
		return editFailed;
	}

	public void setEditFailed(boolean editFailed) {
		this.editFailed = editFailed;
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}

	
	
}
