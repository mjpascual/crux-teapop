package com.upou.teapop.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

public class AddPromoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Promo promo;
	private Promos specials;
	
	
	public String execute(){
		
		PromoDao dao = new PromoDao();
		try {
			System.out.println("TIM " + promo.getImage());
			if(promo.getImage() == null || promo.getImage().isEmpty()){
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
	
	

}
