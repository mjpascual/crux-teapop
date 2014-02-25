package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.Menu;
import com.upou.teapop.data.MenuItem;
import com.upou.teapop.data.MenuSection;
import com.upou.teapop.data.Price;

public class MenuItemDao extends BaseDao {
	
	private static final String MENU_CREATE   = "INSERT INTO teapop.menu (menu_code, category_id, name, description, currency, price, price_small, price_big, position, featured, hidden) " +
                                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	private static final String MENU_VIEW     = "SELECT * FROM teapop.menu WHERE menu_id = ?";
	
	private static final String MENU_VIEW_ALL = "SELECT * FROM teapop.menu";
	
	private static final String MENU_DELETE	  = "DELETE FROM teapop.menu WHERE menu_id = ?";
	
	public static final String MENU_CATEGORY = "SELECT * FROM teapop.category";
	
	public static final String MENU_UPDATE = "UPDATE teapop.menu SET menu_code=?, category_id=?, name=?, description=?, price=?, price_small=?, price_big=?, featured=?, hidden=? WHERE menu_id=?";
	
	public boolean createItem(MenuItem menuItem, Category category) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(MENU_CREATE);
			stmt.setString(1, menuItem.getItemCode());
			stmt.setInt(2, Integer.valueOf(category.getCategoryId()));
			stmt.setString(3, menuItem.getName());
			stmt.setString(4, menuItem.getDesc());
			stmt.setString(5, menuItem.getPrice().getCurrency());
			stmt.setDouble(6, menuItem.getPrice().getRegular());
			stmt.setDouble(7, menuItem.getPrice().getSmall());
			stmt.setDouble(8, menuItem.getPrice().getLarge());
			stmt.setInt(9, menuItem.getDispPosition());
			stmt.setBoolean(10, menuItem.isFeatured());
			stmt.setBoolean(11, menuItem.isHidden());
			System.out.println(stmt);
			stmt.execute();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public MenuItem retrieveItem(int menuId) {
		MenuItem menuItem = new MenuItem();
		try {
			Connection conn = createConnection();

			PreparedStatement stmt = conn.prepareStatement(MENU_VIEW);
			stmt.setInt(1, menuId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				menuItem.setItemId(rs.getInt("menu_id"));
				menuItem.setItemCode(rs.getString("menu_code"));
				menuItem.setCatId(rs.getInt("category_id"));
				menuItem.setName(rs.getString("name"));
				menuItem.setDesc(rs.getString("description"));
				Price price = new Price();
				price.setCurrency(rs.getString("currency"));
				price.setRegular(rs.getDouble("price"));
				price.setSmall(rs.getDouble("price_small"));
				price.setLarge(rs.getDouble("price_big"));
				menuItem.setPrice(price);
				menuItem.setDispPosition(rs.getInt("position"));
				menuItem.setFeatured(rs.getBoolean("featured"));
				menuItem.setHidden(rs.getBoolean("hidden"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItem;
	}
	
	public List<MenuItem> retrieveItems() {
		
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		try {
			Connection conn = createConnection();

			PreparedStatement stmt = conn.prepareStatement(MENU_VIEW_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setItemId(rs.getInt("menu_id"));
				menuItem.setItemCode(rs.getString("menu_code"));
				menuItem.setCatId(rs.getInt("category_id"));
				menuItem.setName(rs.getString("name"));
				menuItem.setDesc(rs.getString("description"));
				Price price = new Price();
				price.setCurrency(rs.getString("currency"));
				price.setRegular(rs.getDouble("price"));
				price.setSmall(rs.getDouble("price_small"));
				price.setLarge(rs.getDouble("price_big"));
				menuItem.setPrice(price);
//				menuItem.setDispPosition(rs.getInt("position"));
				menuItem.setFeatured(rs.getBoolean("featured"));
				menuItem.setHidden(rs.getBoolean("hidden"));
				menuItems.add(menuItem);
			}
			
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItems;
	}

	
	
	
	public boolean deleteItem(int id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(MENU_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
 
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
			PreparedStatement stmt = conn.prepareStatement(MENU_CATEGORY);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setDesc(rs.getString("description"));
				category.setCategoryId(String.valueOf(rs.getInt("category_id")));
				category.setMain(rs.getString("main_category"));
				category.setName(rs.getString("name"));
				category.setImage(rs.getString("image_name"));
				category.setShowSML(rs.getBoolean("show_sml"));
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
	
	
	
	public Menu retrieveMenu() {

		Menu menu = new Menu();
		MenuSection beverages = new MenuSection();
		MenuSection otherMenu = new MenuSection();
		List<Category> categories = retrieveCategories();
		try {

			Connection conn = createConnection();

			// get items info
			PreparedStatement stmt = conn.prepareStatement(MENU_VIEW_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MenuItem item = new MenuItem();
				item.setDesc(rs.getString("description"));
				item.setItemId(rs.getInt("menu_id"));
				item.setName(rs.getString("name"));
				item.setCatId(rs.getInt("category_id"));
				item.setHidden(rs.getBoolean("hidden"));
				item.setFeatured(rs.getBoolean("featured"));
				item.setDispPosition(rs.getInt("position"));
				item.setItemCode(rs.getString("menu_code"));
				Price price = new Price();
				price.setSmall((rs.getDouble("price_small")));
				price.setLarge((rs.getDouble("price_big")));
				price.setRegular((rs.getDouble("price_big")));
				price.setCurrency(rs.getString("currency"));
				item.setPrice(price);
				
				for (Category category : categories){
					if(Integer.parseInt(category.getCategoryId()) == item.getCatId() ){
						item.setCategory(category.getName());
						category.getItems().add(item);
					}
				}
			}		
			
			for(Category category : categories){
				if(category.getMain().equalsIgnoreCase("beverage")){
					beverages.getCategories().add(category);
				} else {
					otherMenu.getCategories().add(category);
				}
			}
			
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		menu.setAdditionalSection(otherMenu);
		menu.setBeveragesSection(beverages);
		
		return menu;
	}

	
	public boolean updateMenu(MenuItem item, Category category){
		boolean result = false;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(MENU_UPDATE);
			
			stmt.setString(1, item.getItemCode());
			stmt.setInt(2, Integer.valueOf(category.getCategoryId()));
			stmt.setString(3, item.getName());
			stmt.setString(4, item.getDesc());
			stmt.setDouble(5, item.getPrice().getRegular());
			stmt.setDouble(6, item.getPrice().getSmall());
			stmt.setDouble(7, item.getPrice().getLarge());
			stmt.setBoolean(8, item.isFeatured());
			stmt.setBoolean(9, item.isHidden());
			stmt.setInt(10, item.getItemId());
			
			stmt.executeUpdate();
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
