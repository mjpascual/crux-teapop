package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.dao.MenuDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.Item;
import com.upou.teapop.data.Menu;
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
		MenuDao dao = new MenuDao();
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
		category1.setShowSML(true);
		
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setDesc("Fruit flavored tea creations that is sure to delight your taste buds!");
		category2.setImage("images/categories/cat2.png");
		category2.setName("Fruit Tea");
		category2.setShowSML(false);
		
		Item item1 = new Item();
		item1.setDesc("black  tea flavor");
		item1.setItemId(1);
		item1.setName("Assam");
		Price price1 = new Price();
		price1.setSmall(90);
		price1.setRegular(100);
		item1.setPrice(price1);
		
		Item item2 = new Item();
		item2.setDesc("floral and creamy");
		item2.setItemId(2);
		item2.setName("Jasmine");
		Price price2 = new Price();
		price2.setSmall(95);
		price2.setRegular(105);
		price2.setLarge(125);
		item2.setPrice(price2);
		
		Item item3 = new Item();
		item3.setDesc("");
		item3.setItemId(3);
		item3.setName("Calamansi");
		Price price3 = new Price();
		price3.setRegular(100);
		item3.setPrice(price3);
		
		Item item4 = new Item();
		item4.setDesc("");
		item4.setItemId(4);
		item4.setName("Cranberry");
		Price price4 = new Price();
		price4.setRegular(100);
		item4.setPrice(price4);
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category2.getItems().add(item3);
		category2.getItems().add(item4);
		
		menu.getCategories().add(category1);
		menu.getCategories().add(category2);
		
		return menu;
	}

}
