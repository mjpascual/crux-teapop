package com.upou.teapop.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.dao.MenuItemDao;
import com.upou.teapop.data.Category;
import com.upou.teapop.data.MenuItem;
import com.upou.teapop.data.Price;



public class MenuDaoTest {

	@Ignore
	@Test
	public void createMenu() {

		MenuItem menu = new MenuItem();
		menu.setItemId(3);
		menu.setCatId(1);
		menu.setItemCode("CHO-MT");
		menu.setName("Chocolate Milk Tea");
		menu.setDesc("Cool");
		Price price = new Price();
		price.setCurrency("P");
		price.setRegular(5.00);
		price.setSmall(3.00);
		price.setLarge(7.00);
		menu.setPrice(price);
		menu.setFeatured("Y");
		menu.setDispPosition(3);
		
		MenuItemDao menuItemDao = new MenuItemDao();
		boolean result = menuItemDao.createItem(menu);
        assertTrue(result);   
        
	}
	
	@Ignore
	@Test
	public void updateCategory() {
	
		MenuItem menu = new MenuItem();
		menu.setItemId(3);
		menu.setCatId(1);
		menu.setItemCode("CHO-MT");
		menu.setName("Chocolate Milk Tea");
		menu.setDesc("Boo");
		Price price = new Price();
		price.setCurrency("P");
		price.setRegular(6.00);
		price.setSmall(3.00);
		price.setLarge(7.00);
		menu.setPrice(price);
		menu.setFeatured("Y");
		menu.setDispPosition(3);
		menu.setHidden("Y");

		MenuItemDao menuItemDao = new MenuItemDao();
		boolean result = menuItemDao.createItem(menu);
        assertTrue(result); 

	}
	
	@Ignore
	@Test
	public void retrieveCategory() {
	
		MenuItemDao menuItemDao = new MenuItemDao();
		MenuItem menu = menuItemDao.retrieveItem(3);
        assertEquals(menu.getName(), "Chocolate Milk Tea");
		
	}

	@Ignore
	@Test
	public void retrieveCategories() {
	
		MenuItemDao menuItemDao = new MenuItemDao();
		List <MenuItem> menu = menuItemDao.retrieveItems();
        assertEquals(menu.get(2).getName(), "Chocolate Milk Tea");
		
	}
	
	@Ignore
	@Test
	public void deleteCategory() {
	
		MenuItemDao menuItemDao = new MenuItemDao();
		Boolean result = menuItemDao.deleteItem(3);
		assertTrue(result);   
		
	}


}
