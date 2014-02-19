package com.upou.teapop.dao.test;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.*;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.Item;
import com.upou.teapop.util.ConnectionManager;

public class MenuDaoTest {

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

	@Test
	public void createItem() {

		try {
			Statement stmt = connection.createStatement();

			Item item = new Item();
			item.setItemCode("DCA-MA");
			item.setCatId(1);
			item.setName("Dark Chocolate Milk Tea");
			item.setDesc("A milk tea with dark chocolate, yum yum");
			item.setCurrency("P");
			item.setPrice(70.00);
			item.setDispPosition(4);
			item.setImage("noimage.jpg");
			item.setFeatured("Y");
			item.setHidden("Y");

			String query = "INSERT INTO teapop.product (product_code, category_id, name, description, currency, price, position, featured, hidden) "
					+ "VALUES ('"
					+ item.getItemCode()
					+ "',"
					+ item.getCatId()
					+ ", '"
					+ item.getName()
					+ "', '"
					+ item.getDesc()
					+ "', '"
					+ item.getCurrency()
					+ "', "
					+ item.getPrice()
					+ ","
					+ item.getDispPosition()
					+ ", '"
					+ item.getFeatured()
					+ "', '" + item.getHidden() + "')";

			stmt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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

	// // RETRIEVE
	// public List<Category> retrieveCategories(){
	//
	// List<Category> categories = new ArrayList<Category>();
	// try {
	// Connection conn = createConnection();
	//
	// // get category info
	// Statement stmt = conn.createStatement();
	// String query = "SELECT * FROM category";
	// ResultSet rs = stmt.executeQuery(query);
	//
	// while (rs.next()) {
	// Category category = new Category();
	// category.setDesc(rs.getString("description"));
	// category.setCategoryId(rs.getInt("id"));
	// category.setName(rs.getString("name"));
	// categories.add(category);
	// }
	// conn.close();
	// stmt.close();
	// rs.close();
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return categories;
	// }
	//
	// public Item retrieveItem(String itemId){
	// Item item = new Item();
	// try {
	// Connection conn = createConnection();
	//
	// // get category info
	// Statement stmt = conn.createStatement();
	// String query = "SELECT * FROM items";
	// ResultSet rs = stmt.executeQuery(query);
	//
	// while (rs.next()) {
	// item.setDesc(rs.getString("description"));
	// item.setItemId(rs.getInt("id"));
	// item.setName(rs.getString("name"));
	// }
	// conn.close();
	// stmt.close();
	// rs.close();
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return item;
	// }
	//
	// public Category retrieveCategory(String categoryId){
	// Category category = new Category();
	// try {
	// Connection conn = createConnection();
	//
	// // get category info
	// Statement stmt = conn.createStatement();
	// String query = "SELECT * FROM category";
	// ResultSet rs = stmt.executeQuery(query);
	//
	// while (rs.next()) {
	// category.setDesc(rs.getString("description"));
	// category.setCategoryId(rs.getInt("id"));
	// category.setName(rs.getString("name"));
	// }
	// conn.close();
	// stmt.close();
	// rs.close();
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return category;
	// }
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
