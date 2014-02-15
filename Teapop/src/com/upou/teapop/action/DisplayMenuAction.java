package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.MenuDao;
import com.upou.teapop.data.Menu;


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
		MenuDao dao = new MenuDao();
		menu = dao.retrieveMenu();
		return SUCCESS;
	}

}
