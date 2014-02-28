package com.upou.teapop.action;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

public class AddPromoAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private Promo promo;
	private Promos specials;
	
	private File myFile;
    private String myFileContentType;
    private String myFileFileName;
	
	public String execute(){
		
		PromoDao dao = new PromoDao();
		try {
			
			if(getMyFileFileName() != null && !getMyFileFileName().equals("")) {
			
				ServletContext context = ServletActionContext.getServletContext();
				
				String appPath = context.getRealPath("");
				String filePath = appPath+DisplayConstants.PROMOS_IMAGE_PATH;
		       
				File fileToCreate = new File(filePath, getMyFileFileName());
				FileUtils.copyFile(getMyFile(), fileToCreate);
		        
		        promo.setImage(getMyFileFileName());
		        
			} else {
				
				promo.setImage("default.png");
				
			}
			
			if(!promo.getName().isEmpty() && !promo.getDesc().isEmpty()){
				if(dao.createPromo(promo)){
					addActionMessage(promo.getName() + DisplayConstants.ADD_SUCCESS);
				} else {
					addActionError("Promo " + promo.getName() + " Add Failed");
				}
			} else {
				addActionError("Promo " + promo.getName() + " Add Failed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
		}
		
		specials = dao.retrievePromos();
		return SUCCESS;
	}
	
	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
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
