package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.Menu;
import com.upou.teapop.data.MenuItem;

public class UpdateMenuAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuItem menuItem;
	
	private Menu menu;
	
	private Category category;
	
	private boolean featured;
	
	private boolean hidden;
	
	public String execute(){
		MenuItemDao dao = new MenuItemDao();
		try {
			menuItem.setHidden(hidden);
			menuItem.setFeatured(featured);
			if(dao.updateMenu(menuItem, category)){
				addActionMessage("Item #" + menuItem.getItemId() + DisplayConstants.UPDATE_SUCCESS);
				System.out.println("1");
			} else {
				addActionError("Item #" + menuItem.getItemId() + " UPDATE FAILED");
				System.out.println("SUCCESS");
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		System.out.println("SUCCESS");
		menu = dao.retrieveMenu();
		if(menu==null){
			System.out.println("NULL");
		}
		return SUCCESS;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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


	public boolean isFeatured() {
		return featured;
	}


	public void setFeatured(boolean featured) {
		this.featured = featured;
	}


	public boolean isHidden() {
		return hidden;
	}


	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
	
	
	
}
