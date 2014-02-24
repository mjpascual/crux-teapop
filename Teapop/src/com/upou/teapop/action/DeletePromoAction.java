package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promos;

public class DeletePromoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int promoId;
	
	private Promos specials;
	
	private boolean deleteSuccessful;
	
	private boolean deleteFailed;
	
	public String deletePromo(){
		PromoDao dao = new PromoDao();
		if(dao.deletePromo(promoId)){
			specials = dao.retrievePromos();
			deleteSuccessful = true;
		} else {
			deleteFailed = true;
		}
		return SUCCESS;
	}
	

	public int getPromoId() {
		return promoId;
	}


	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}


	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}


	public boolean isDeleteSuccessful() {
		return deleteSuccessful;
	}


	public void setDeleteSuccessful(boolean deleteSuccessful) {
		this.deleteSuccessful = deleteSuccessful;
	}


	public boolean isDeleteFailed() {
		return deleteFailed;
	}


	public void setDeleteFailed(boolean deleteFailed) {
		this.deleteFailed = deleteFailed;
	}
	
	
	

}
