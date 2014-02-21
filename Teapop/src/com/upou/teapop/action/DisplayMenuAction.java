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
//		menu = dao.retrieveMenu();
		menu = getMockMenu();
		return SUCCESS;
	}
	
	private Menu getMockMenu(){
		Menu menu = new Menu();
		
		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setDesc("A Serenitea specialty! Our best seller drinks have the goodness of milk combined with unique tea blends.");
		category1.setImage("images/categories/cat1.png");
		category1.setName("Milk Tea Classics");
		category1.setShowSML("Y");
		
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setDesc("Fruit flavored tea creations that is sure to delight your taste buds!");
		category2.setImage("images/categories/cat2.png");
		category2.setName("Fruit Tea");
		category2.setShowSML("Y");
		
		MenuItem item1 = new MenuItem();
		item1.setDesc("black  tea flavor");
		item1.setItemId(1);
		item1.setName("Assam");
		Price price1 = new Price();
		price1.setSmall(90);
		price1.setRegular(100);
		item1.setPrice(price1);
		
		MenuItem item2 = new MenuItem();
		item2.setDesc("brown  tea flavor");
		item2.setItemId(1);
		item2.setName("Brown");
		Price price2 = new Price();
		price2.setSmall(90);
		price2.setRegular(100);
		item1.setPrice(price1);
		

		MenuItem item3 = new MenuItem();
		item3.setDesc("brown  tea flavor");
		item3.setItemId(1);
		item3.setName("Brown");
		Price price3 = new Price();
		price3.setSmall(90);
		price3.setRegular(100);
		item3.setPrice(price1);
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category2.getItems().add(item3);

		MenuSection beverages = new MenuSection();
		beverages.getCategories().add(category1);
		beverages.getCategories().add(category2);
		menu.setBeveragesSection(beverages);
		
		return menu;
	}

}
