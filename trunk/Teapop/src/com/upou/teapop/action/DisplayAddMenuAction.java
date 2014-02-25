package com.upou.teapop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;

public class DisplayAddMenuAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	private List<Category> categories;
	
	public String execute(){
		CategoryDao dao = new CategoryDao();
		categories = dao.retrieveCategories();
		action = "addMenu";
		return SUCCESS;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
}
