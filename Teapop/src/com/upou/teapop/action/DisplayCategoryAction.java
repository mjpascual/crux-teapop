package com.upou.teapop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;

public class DisplayCategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Category> categoryList;

	public String execute() {
		CategoryDao categoryDao = new CategoryDao();
		categoryList = categoryDao.retrieveCategories();
		return SUCCESS;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

}
