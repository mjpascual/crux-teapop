package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.Beverage;
import com.upou.teapop.data.Menu;
import com.upou.teapop.data.PriceSML;

public class MenuDao extends BaseDao {

	public boolean createItem(Beverage beverage) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT INTO teapop.product (product_code, category_id, name, description, currency, regular_price, small_price, large_price, position, featured, hidden) "
					+ "VALUES ('"
					+ beverage.getItemCode()
					+ "',"
					+ beverage.getCatId()
					+ ", '"
					+ beverage.getName()
					+ "', '"
					+ beverage.getDesc()
					+ "', '"
					+ beverage.getPrice().getCurrency()
					+ "', "
					+ beverage.getPrice().getRegular()
					+ ","
					+ beverage.getPrice().getSmall()
					+ ","
					+ beverage.getPrice().getLarge()
					+ ","
					+ beverage.getDispPosition()
					+ ", '"
					+ beverage.getFeatured()
					+ "', '" + beverage.getHidden() + "')";

			stmt.executeUpdate(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean createCategory(Category category) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT INTO teapop.category(name, description, image_name) VALUES "
					+ "('"
					+ category.getName()
					+ "', '"
					+ category.getDesc()
					+ "', '" + category.getImage() + "')";

			stmt.executeUpdate(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// RETRIEVE
	public List<Category> retrieveCategories() {

		List<Category> categories = new ArrayList<Category>();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Category category = new Category();
				category.setDesc(rs.getString("description"));
				category.setCategoryId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				categories.add(category);
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	public Beverage retrieveItem(int itemId) {
		Beverage item = new Beverage();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM teapop.product";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				item.setDesc(rs.getString("description"));
				item.setItemId(rs.getInt("product_id"));
				item.setName(rs.getString("name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	public Category retrieveCategory(String categoryId) {
		Category category = new Category();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				category.setDesc(rs.getString("description"));
				category.setCategoryId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	public Menu retrieveMenu() {

		Menu menu = new Menu();

		// create map for categories
		HashMap<Integer, Category> categoryMap = new HashMap<Integer, Category>();
		for (Category category : retrieveCategories()) {
			categoryMap.put(category.getCategoryId(), category);
		}

		try {

			Connection conn = createConnection();

			// get items info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM items LEFT JOIN category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Beverage item = new Beverage();
				item.setDesc(rs.getString("description"));
				item.setItemId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				
				PriceSML price = new PriceSML();
				double regularPrice = rs.getDouble("price");
				price.setRegular(regularPrice);
				
				// TODO get actual large and small price
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

	// UPDATE
	public boolean updateItem(Beverage item) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT VALUES() INTO menu";

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateCategory(Category category) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT VALUES() INTO menu";

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// DELETE
	public boolean deleteItem(String id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "DELETE FROM items WHERE id=" + id;

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean deleteCategory(String id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "DELETE FROM category WHERE id=" + id;

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
