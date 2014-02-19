package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.MenuDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.Item;
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
//		menu = dao.retrieveMenu();
		menu = getMockMenu();
		return SUCCESS;
	}
	
	private Menu getMockMenu(){
		Menu menu = new Menu();
		
		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setDesc("desc1");
		category1.setImage("images/categories/cat1.png");
		category1.setName("name1");
		
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setDesc("desc2");
		category2.setImage("images/categories/cat2.png");
		category2.setName("name2");
		
		Item item1 = new Item();
		item1.setDesc("desc1");
		item1.setItemId(1);
		item1.setName("name1");
		item1.setPrice("1001");
		
		Item item2 = new Item();
		item2.setDesc("desc2");
		item2.setItemId(2);
		item2.setName("name2");
		item2.setPrice("1002");
		
		Item item3 = new Item();
		item3.setDesc("desc3");
		item3.setItemId(3);
		item3.setName("name3");
		item3.setPrice("1003");
		
		Item item4 = new Item();
		item4.setDesc("desc4");
		item4.setItemId(4);
		item4.setName("name4");
		item4.setPrice("1004");
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category2.getItems().add(item3);
		category2.getItems().add(item4);
		
		menu.getCategories().add(category1);
		menu.getCategories().add(category2);
		
		return menu;
	}

}
