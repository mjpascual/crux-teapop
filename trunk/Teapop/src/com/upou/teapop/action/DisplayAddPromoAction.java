package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;

public class DisplayAddPromoAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String action;
	private boolean edit;
	
	
	public String execute(){
		
		action = "addPromo";
		edit = false;
		return SUCCESS;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	
}
