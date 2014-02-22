package com.upou.teapop.dao.test;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Ignore;
import org.junit.Test;

import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;

public class CategoryDaoTest {


	@Ignore
	@Test
	public void createCategory() {

		Category category = new Category();
		category.setCategoryId(0);
		category.setMain("Bevarage");
		category.setName("Italian Soda");
		category.setDesc("Sweet");
		category.setImage("candy.jpg");
		category.setShowSML("Y");
		
		CategoryDao categoryDao = new CategoryDao();
		boolean result = categoryDao.createCategory(category);
        assertTrue(result);   
        
	}
	
	@Ignore
	@Test
	public void updateCategory() {
	
		Category category = new Category();
		category.setCategoryId(3);
		category.setMain("Bevarage");
		category.setName("Italian Soda");
		category.setDesc("Sweet");
		category.setImage("sweet.jpg");
		category.setShowSML("Y");
		
		CategoryDao categoryDao = new CategoryDao();
		boolean result = categoryDao.createCategory(category);
        assertTrue(result);   

	}
	
	@Ignore
	@Test
	public void retrieveCategory() {
	
		CategoryDao categoryDao = new CategoryDao();
		Category cat = categoryDao.retrieveCategory(3);
        assertEquals(cat.getName(), "Italian Soda");
		
	}
	
	@Ignore
	@Test
	public void retrieveCategories() {
	
		CategoryDao categoryDao = new CategoryDao();
		List <Category> cat = categoryDao.retrieveCategories();
        assertEquals(cat.get(2).getName(), "Italian Soda");
		
	}
	
	
	
	@Test
	public void deleteCategory() {
	
		CategoryDao categoryDao = new CategoryDao();
		Boolean result = categoryDao.deleteCategory(3);
		assertTrue(result);   
		
	}


}
