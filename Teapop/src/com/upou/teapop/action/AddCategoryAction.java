package com.upou.teapop.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;
import javax.servlet.ServletContext;

public class AddCategoryAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private List<Category> categoryList;
	
	private Category category;
	
	private File myFile;
    private String myFileContentType;
    private String myFileFileName;
	
	public String execute(){
		
		CategoryDao categoryDao = new CategoryDao();
		
		boolean result = false;
		
		try {
			
			if(getMyFileFileName() != null && !getMyFileFileName().equals("")) {
				
				ServletContext context = ServletActionContext.getServletContext();
				
				String appPath = context.getRealPath("");
				String filePath = appPath+DisplayConstants.CAT_IMAGE_PATH;
		       
				File fileToCreate = new File(filePath, getMyFileFileName());
		        FileUtils.copyFile(getMyFile(), fileToCreate);
		    
		        category.setImage(getMyFileFileName());
		        
			} else {
				
				category.setImage(DisplayConstants.DEFAULT_CAT_IMG);
				
			}
	        
			result = categoryDao.createCategory(category);
			
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
		} catch (IOException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
			return ERROR;
		} catch (Exception e){
			addActionError(ErrorConstants.SEV_ERROR + e);
			return ERROR;
		}
		
		categoryList = categoryDao.retrieveCategories();
		addActionMessage(DisplayConstants.CAT_ADD_SUCCESS);
		
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

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	

}
