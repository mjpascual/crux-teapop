package com.upou.teapop.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.upou.teapop.data.Category;
import com.upou.teapop.util.ConnectionManager;

public class CategoryDaoTest {

	static ConnectionManager connectionManager;
	static Connection connection;

	@BeforeClass
	public static void start() {
		connectionManager = new ConnectionManager();
		connection = connectionManager.createConnection();
	}

	@AfterClass
	public static void end() {
		connectionManager.closeConnection();
	}
	
	@Ignore
	@Test
	public void createCategory() {

		try {
			Statement stmt = connection.createStatement();
			Category category = new Category();
			category.setName("Candies");
			category.setDesc("Sweet");
			category.setImage("candy.jpg");

			String query = "INSERT INTO teapop.category(name, description, image_name) VALUES "
					+ "('"
					+ category.getName()
					+ "', '"
					+ category.getDesc()
					+ "', '" + category.getImage() + "')";

			stmt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void retrieveCategories() {

		List<Category> categories = new ArrayList<Category>();
		try {

			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Category category = new Category();
				category.setDesc(rs.getString("description"));
				category.setCategoryId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImage(rs.getString("image_name"));
				categories.add(category);
			}

			assertEquals(categories.get(0).getName(), "Milk Tea");
			assertEquals(categories.get(1).getName(), "Pasta");
			assertEquals(categories.get(2).getName(), "Appetizer");
			assertEquals(categories.get(3).getName(), "Rice Meals");
			
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
