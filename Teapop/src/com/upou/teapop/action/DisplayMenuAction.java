package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.Menu;
import com.upou.teapop.data.MenuItem;
import com.upou.teapop.data.MenuSection;
import com.upou.teapop.data.Price;


public class DisplayMenuAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public String execute(){
		MenuItemDao dao = new MenuItemDao();
		menu = dao.retrieveMenu();
		return SUCCESS;
	}
}
