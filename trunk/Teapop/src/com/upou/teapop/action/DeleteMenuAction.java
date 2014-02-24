package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
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
		System.out.println("TIM" + itemId);
		MenuItemDao dao = new MenuItemDao();
		if(dao.deleteItem(itemId)){
			menu = dao.retrieveMenu();
		} else {
			System.out.println("FAILED");
		}
		
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
