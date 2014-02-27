package com.upou.teapop.dao.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import org.junit.Ignore;
import org.junit.Test;

import com.upou.teapop.dao.CategoryDao;
import com.upou.teapop.data.Category;

public class CategoryDaoTest {


	@Test
	public void createCategory() {

		Category category = new Category();
		category.setCategoryId("0");
		category.setMain("Bevarage");
		category.setName("Italian Soda");
		category.setDesc("Sweet");
		category.setShowSML(true);
		category.setDisp("3");
		
		CategoryDao categoryDao = new CategoryDao();
		boolean result = false;
		try {
			result = categoryDao.createCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        assertTrue(result);   
        
	}
	
	@Ignore
	@Test
	public void updateCategory() {
	
		Category category = new Category();
		category.setCategoryId("3");
		category.setMain("Bevarage");
		category.setName("Italian Soda");
		category.setDesc("Sweet");
		category.setDisp("3");
		category.setShowSML(true);
	
		CategoryDao categoryDao = new CategoryDao();
		boolean result = false;
		try {
			result = categoryDao.createCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        assertTrue(result);   

	}
	
	@Ignore
	@Test
	public void retrieveCategory() {
	
		CategoryDao categoryDao = new CategoryDao();
		Category cat = null;
		try {
			cat = categoryDao.retrieveCategory("3");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(cat.getName(), "Italian Soda");
			
	}
	
	@Ignore
	@Test
	public void retrieveCategories() {
	
		CategoryDao categoryDao = new CategoryDao();
		List <Category> cat = categoryDao.retrieveCategories();
        assertEquals(cat.get(2).getName(), "Italian Soda");
		
	}
	
	@Ignore
	@Test
	public void deleteCategory() {
	
		CategoryDao categoryDao = new CategoryDao();
		Boolean result = false;
		try {
			result = categoryDao.deleteCategory("3");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result);   
		
	}


}
