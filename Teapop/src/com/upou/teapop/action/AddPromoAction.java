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
	private boolean addSuccessful;
	private boolean addFailed;
	
	public String addPromo(){
		
		PromoDao dao = new PromoDao();
		try {
			if(promo.getImage() == null){
				promo.setImage("default.png");
			}
			
			if(!promo.getName().isEmpty() && !promo.getDesc().isEmpty()){
				if(dao.createPromo(promo)){
					addSuccessful = true;
				} else {
					addFailed = true;
				}
			} else {
				addFailed = true;
			}
			
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public boolean isAddSuccessful() {
		return addSuccessful;
	}

	public void setAddSuccessful(boolean addSuccessful) {
		this.addSuccessful = addSuccessful;
	}

	public boolean isAddFailed() {
		return addFailed;
	}

	public void setAddFailed(boolean addFailed) {
		this.addFailed = addFailed;
	}
	
	
	
	
}
