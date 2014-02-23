package com.upou.teapop.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;

public class DeleteCategoryAction extends ActionSupport  {
	
private static final long serialVersionUID = 1L;
	
	private List<Category> categoryList;
	private String catergoryId;
	
	public String execute(){
		
		CategoryDao categoryDao = new CategoryDao();
		
		boolean result = false;
		
		try {
			
			categoryList = categoryDao.retrieveCategories();

			result = categoryDao.deleteCategory(catergoryId);
			
			
			if(result == false){
				addActionError(ErrorConstants.SEV_ERROR);
				return ERROR;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
			return ERROR;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.INPUT_ERROR + e);
			return ERROR;
		} catch (Exception e){
			addActionError(ErrorConstants.SEV_ERROR + e);
			return ERROR;
		}

		addActionMessage("Data #" + catergoryId + DisplayConstants.DELETE_SUCCESS);
		return SUCCESS;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public String getCatergoryId() {
		return catergoryId;
	}

	public void setCatergoryId(String catergoryId) {
		this.catergoryId = catergoryId;
	}

	

}
