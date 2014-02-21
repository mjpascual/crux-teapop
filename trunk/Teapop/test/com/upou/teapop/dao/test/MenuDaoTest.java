package com.upou.teapop.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.MenuItem;
import com.upou.teapop.data.Price;
import com.upou.teapop.util.ConnectionManager;

public class MenuDaoTest {

//	static ConnectionManager connectionManager;
//	static Connection connection;
//
//	@BeforeClass
//	public static void start() {
//		connectionManager = new ConnectionManager();
//		connection = connectionManager.createConnection();
//	}
//
//	@AfterClass
//	public static void end() {
//		connectionManager.closeConnection();
//	}
//
//	@Ignore
//	@Test
//	public void createItem() {
//
//		try {
//			Statement stmt = connection.createStatement();
//			

//			private int itemId;
//
//			private int catId;
//
//			private int dispPosition;
//
//			private String itemCode;
//
//			private String name;
//
//			private String desc;
//
//			private String featured;
//
//			private String hidden;
//			
//			private String size;
//			
//			private String image;

//			MenuItem item = new Beverage();
//			item.setItemCode("DCA-MA");
//			item.setCatId(1);
//			item.setName("Dark Chocolate Milk Tea");
//			item.setDesc("A milk tea with dark chocolate, yum yum");
//			
//			item.setDispPosition(5);
//			item.setImage("noimage.jpg");
//			item.setFeatured("Y");
//			item.setHidden("Y");
//			item.setSize("Small");
//
//			String query = "INSERT INTO teapop.product (menu_code, category_id, name, description, price, price_small, price_big, image_name, featured, hidden, currency, position) "
//					+ "VALUES ('"
//					+ item.getItemCode()
//					+ "',"
//					+ item.getCatId()
//					+ ", '"
//					+ item.getName()
//					+ "', '"
//					+ item.getDesc()
//					+ "', '"
//					+ item.getCurrency()
//					+ "', "
//					+ item.getPriceVal()
//					+ ","
//					+ item.getDispPosition()
//					+ ", '"
//					+ item.getFeatured()
//					+ "', '" 
//					+ item.getHidden() 
//					+ "', '" 
//					+ item.getSize() + "')";
//
//			stmt.executeUpdate(query);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	@Test
//	public void retrieveItem() {
//		Item item = new Item();
//		int itemId = 1;
//	
//		try {
//
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM product WHERE id = "+itemId;
//			ResultSet rs = stmt.executeQuery(query);
//			
//			
////			  `price`, `store_id`, `position`, `image_name`, `featured`, `hidden`, `currency`
//			while (rs.next()) {
//				
//				item.setItemId(rs.getInt("product_id"));
//				item.setItemCode(rs.getString("product_code"));
//				item.setCatId(rs.getInt("category_id"));
//				item.setName(rs.getString("name"));
//				item.setDesc(rs.getString("description"));
//				item.setImage(rs.getString("image_name"));
//				item.setPrice(rs.getDouble("price"));
//				item.setDispPosition(rs.getInt("position"));
//			
//				
//			}
//			
//			assertEquals(item.getName(), "Milk Tea");
//		
//			stmt.close();
//			rs.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

//	public Category retrieveCategory(String categoryId) {
//		Category category = new Category();
//		
//		try {
//		
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM category";
//			ResultSet rs = stmt.executeQuery(query);
//
//			while (rs.next()) {
//				category.setDesc(rs.getString("description"));
//				category.setCategoryId(rs.getInt("id"));
//				category.setName(rs.getString("name"));
//			}
////			conn.close();
//			stmt.close();
//			rs.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return category;
//	}
	//
	// public Menu retrieveMenu() {
	//
	// Menu menu = new Menu();
	//
	// // create map for categories
	// HashMap<Integer, Category> categoryMap = new HashMap<Integer,
	// Category>();
	// for (Category category : retrieveCategories()) {
	// categoryMap.put(category.getCategoryId(), category);
	// }
	//
	// try {
	//
	// Connection conn = createConnection();
	//
	//
	// // get items info
	// Statement stmt = conn.createStatement();
	// String query = "SELECT * FROM items LEFT JOIN category";
	// ResultSet rs = stmt.executeQuery(query);
	//
	// while (rs.next()) {
	// Item item = new Item();
	// item.setDesc(rs.getString("description"));
	// item.setItemId(rs.getInt("id"));
	// item.setName(rs.getString("name"));
	// item.setPrice(rs.getString("price"));
	//
	// int categoryId = rs.getInt("categoryId");
	// if (categoryMap.containsKey(categoryId)){
	// categoryMap.get(categoryId).getItems().add(item);
	// } else {
	// System.out.println("NO MATCHING CATEGORY ID");
	// }
	// }
	// conn.close();
	// stmt.close();
	// rs.close();
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return menu;
	// }
	//
	// // UPDATE
	// public boolean updateItem(Item item) {
	// boolean result = false;
	// try {
	// Connection conn = createConnection();
	// Statement stmt = conn.createStatement();
	//
	// String query = "INSERT VALUES() INTO menu";
	//
	// stmt.executeQuery(query);
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// public boolean updateCategory(Category category) {
	// boolean result = false;
	// try {
	// Connection conn = createConnection();
	// Statement stmt = conn.createStatement();
	//
	// String query = "INSERT VALUES() INTO menu";
	//
	// stmt.executeQuery(query);
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// // DELETE
	// public boolean deleteItem(String id) {
	// boolean result = false;
	// try {
	// Connection conn = createConnection();
	// Statement stmt = conn.createStatement();
	//
	// String query = "DELETE FROM items WHERE id=" + id;
	//
	// stmt.executeQuery(query);
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// public boolean deleteCategory(String id) {
	// boolean result = false;
	// try {
	// Connection conn = createConnection();
	// Statement stmt = conn.createStatement();
	//
	// String query = "DELETE FROM category WHERE id=" + id;
	//
	// stmt.executeQuery(query);
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	// }

}
