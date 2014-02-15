package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.SpecialsDao;
import com.upou.teapop.data.Specials;

public class DisplaySpecialsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Specials specials;
	
	public String execute(){
		SpecialsDao dao = new SpecialsDao();
		setSpecials(dao.retrievePromos());
		return SUCCESS;
	}

	public Specials getSpecials() {
		return specials;
	}

	public void setSpecials(Specials specials) {
		this.specials = specials;
	}

}
