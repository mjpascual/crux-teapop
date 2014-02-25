package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.Menu;
import com.upou.teapop.data.MenuItem;

public class AddMenuAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuItem menuItem;
	
	private Category category;
	
	private Menu menu;
	 
	public String execute(){
		
		MenuItemDao dao = new MenuItemDao();
		try {
			System.out.println(category.getCategoryId());
			if(dao.createItem(menuItem, category)){
				addActionMessage(menuItem.getName() + DisplayConstants.ADD_SUCCESS);
			} else {
				addActionError(menuItem.getName() + " add failed");
			}
		} catch (Exception e) {
			addActionError(menuItem.getName() + " add failed");
			e.printStackTrace();
		}
		menu = dao.retrieveMenu();
		return SUCCESS;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
	

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	 
}
