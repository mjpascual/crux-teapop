package com.upou.teapop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.MenuItem;

public class DisplayUpdateMenuAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int itemId;
	
	private MenuItem menuItem;
	
	private boolean edit;
	
	private List<Category> categories;
	
	public String execute(){
		
		try {
			MenuItemDao menuDao = new MenuItemDao();
			CategoryDao categoryDao = new CategoryDao();
			categories = categoryDao.retrieveCategories();
			menuItem = menuDao.retrieveItem(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		edit = true;
		return SUCCESS;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
