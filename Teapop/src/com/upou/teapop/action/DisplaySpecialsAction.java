package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promos;

public class DisplaySpecialsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Promos specials;
	
	public String execute(){
		PromoDao dao = new PromoDao();
		try {
			specials = dao.retrievePromos();	
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
		}
		
		return SUCCESS;
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}


}
