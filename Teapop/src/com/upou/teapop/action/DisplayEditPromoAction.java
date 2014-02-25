package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;

public class DisplayEditPromoAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int promoId;
	
	private Promo promo;
	
	private boolean edit;
	
	private String action;
	
	public String execute(){
		try {
			PromoDao dao = new PromoDao();
			promo = dao.retrievePromo(promoId);
			edit = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		action = "updatePromo";
		return SUCCESS;
	}


	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}


	public Promo getPromo() {
		return promo;
	}


	public void setPromo(Promo promo) {
		this.promo = promo;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}
	
	
}
