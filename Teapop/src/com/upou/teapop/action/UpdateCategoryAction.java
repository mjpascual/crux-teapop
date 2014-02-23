package com.upou.teapop.action;


import java.sql.SQLException;


import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;


public class UpdateCategoryAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Category category;
	
	private String catergoryId;
	
	public String execute(){
		
		CategoryDao categoryDao = new CategoryDao();
		
		try {
			
			category = categoryDao.retrieveCategory(catergoryId);
			
			if(category.getName() == null || category.getName().equals("")){
				addActionError(ErrorConstants.SEV_ERROR);
				return ERROR;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e.getMessage());
			return ERROR;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.INPUT_ERROR + e.getMessage());
			return ERROR;
		} catch (Exception e){
			addActionError(ErrorConstants.SEV_ERROR + e.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCatergoryId() {
		return catergoryId;
	}

	public void setCatergoryId(String catergoryId) {
		this.catergoryId = catergoryId;
	}



}
