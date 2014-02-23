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
//		menu = getMockMenu();
		return SUCCESS;
	}
	
	private Menu getMockMenu(){
		Menu menu = new Menu();
		
		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setDesc("A Serenitea specialty! Our best seller drinks have the goodness of milk combined with unique tea blends.");
		category1.setImage("cat1.png");
		category1.setName("Milk Tea Classics");
		category1.setShowSML(true);
		
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setDesc("Fruit flavored tea creations that is sure to delight your taste buds!");
		category2.setImage("cat2.png");
		category2.setName("Fruit Tea");
		category2.setShowSML(false);
		
		MenuItem item1 = new MenuItem();
		item1.setDesc("black tea flavor");
		item1.setItemId(1);
		item1.setName("Assam");
		Price price1 = new Price();
		price1.setRegular(100);
		price1.setLarge(120);
		item1.setPrice(price1);
		
		MenuItem item2 = new MenuItem();
		item2.setDesc("Wintermelon tea flavor");
		item2.setItemId(2);
		item2.setName("Wintermelon");
		Price price2 = new Price();
		price2.setSmall(90);
		price2.setRegular(100);
		price2.setLarge(120);
		item2.setPrice(price2);
		

		MenuItem item3 = new MenuItem();
		item3.setDesc("brown tea flavoar");
		item3.setItemId(3);
		item3.setName("Brown Tea");
		Price price3 = new Price();
		price3.setSmall(90);
		price3.setRegular(100);
		price3.setLarge(120);
		item3.setPrice(price3);
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category1.getItems().add(item1);
		category1.getItems().add(item2);
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
