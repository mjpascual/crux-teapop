package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.MenuDao;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.MenuItem;

public class AddMenuAction extends ActionSupport{
	
	private MenuItem menuItem;
	
	private Category category;
	 
	public String execute(){
		
		
		try {
			try {
				MenuItemDao dao = new MenuItemDao();
				dao.createItem(menuItem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	 
}
