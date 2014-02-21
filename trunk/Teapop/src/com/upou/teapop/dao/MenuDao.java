package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.Menu;
import com.upou.teapop.data.MenuItem;
import com.upou.teapop.data.Price;

public class MenuDao extends BaseDao{

	public Menu retrieveMenu() {

		Menu menu = new Menu();

		// create map for categories
		HashMap<Integer, Category> categoryMap = new HashMap<Integer, Category>();
		CategoryDao categoryDao = new CategoryDao();
		for (Category category : categoryDao.retrieveCategories()) {
			categoryMap.put(category.getCategoryId(), category);
		}

		try {

			Connection conn = createConnection();

			// get items info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM items LEFT JOIN category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				MenuItem item = new MenuItem();
				item.setDesc(rs.getString("description"));
				item.setItemId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				
				Price price = new Price();
				double regularPrice = rs.getDouble("price");
				price.setRegular(regularPrice);
				price.setLarge(regularPrice + 10);
				price.setSmall(regularPrice - 10);
				
				item.setPrice(price);
				
				int categoryId = rs.getInt("categoryId");
				if (categoryMap.containsKey(categoryId)) {
					categoryMap.get(categoryId).getItems().add(item);
				} else {
					System.out.println("NO MATCHING CATEGORY ID");
				}
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

}
