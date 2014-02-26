package com.upou.teapop.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Menu;

public class DeleteMenuAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int itemId;
	
	private Menu menu;
	
	public String deleteMenu(){
		MenuItemDao dao = new MenuItemDao();
		try {
			if(dao.deleteItem(itemId)){
				addActionMessage("Item #" + itemId  + DisplayConstants.DELETE_SUCCESS);
			} else {
				addActionError("Failed to Delete Promo #" + itemId);
			}
		} catch (SQLException e) {
			addActionError(ErrorConstants.SEV_ERROR + e);
			e.printStackTrace();
		} catch (Exception e) {
			addActionError(ErrorConstants.SEV_ERROR + e);
			e.printStackTrace();
		}
		
		menu = dao.retrieveMenu();
		
		return SUCCESS;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	
	
}
