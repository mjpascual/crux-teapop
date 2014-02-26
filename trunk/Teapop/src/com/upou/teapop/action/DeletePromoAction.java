package com.upou.teapop.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promos;

public class DeletePromoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int promoId;
	
	private Promos specials;
	
	public String deletePromo(){
		PromoDao dao = new PromoDao();
		
		try {
			if(dao.deletePromo(promoId)){
				addActionMessage("Promo #" + promoId  + DisplayConstants.DELETE_SUCCESS);
			} else {
				addActionError("Failed to Delete Promo #" + promoId);
			}
			
			specials = dao.retrievePromos();
			
		} catch (SQLException e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(ErrorConstants.SEV_ERROR + e);
		}
		
		return SUCCESS;
	}
	

	public int getPromoId() {
		return promoId;
	}


	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}


	public Promos getSpecials() {
		return specials;
	}

	public void setSpecials(Promos specials) {
		this.specials = specials;
	}
}
