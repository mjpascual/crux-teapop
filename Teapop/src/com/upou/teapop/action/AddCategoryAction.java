package com.upou.teapop.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DBConstants;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;


public class AddCategoryAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private List<Category> categoryList;
	private Category category;
	
	public String execute(){
		
		CategoryDao categoryDao = new CategoryDao();
		
		boolean result = false;
		
		try {
			if(category.getImage() == null || category.getImage().equals("")){
				category.setImage(DisplayConstants.DEFAULT_CAT_IMG);
			}
			result = categoryDao.createCategory(category);
			
			if(result == false){
				addActionError(ErrorConstants.SEV_ERROR);
				return ERROR;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e.getMessage());
			return ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e.getMessage());
			return ERROR;
		} catch (Exception e){
			addActionError(ErrorConstants.SEV_ERROR + e.getMessage());
			return ERROR;
		}
		
		categoryList = categoryDao.retrieveCategories();
		addActionMessage(DisplayConstants.ADD_SUCCESS);
		
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	

}
