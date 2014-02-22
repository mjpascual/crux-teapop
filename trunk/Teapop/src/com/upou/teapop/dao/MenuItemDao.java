package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.MenuItem;
import com.upou.teapop.data.Price;

public class MenuItemDao extends BaseDao {
	
	private static final String MENU_CREATE   = "INSERT INTO teapop.menu (menu_id, menu_code, category_id, name, description, currency, price, price_small, price_big, position, featured, hidden) " +
                                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                                                "ON DUPLICATE KEY UPDATE menu_id = VALUES(menu_id), menu_code = VALUES(menu_code), category_id = VALUES(category_id), name=VALUES(name), description = VALUES(description), " +
                                                "currency = VALUES(currency), price=VALUES(price), price_small=VALUES(price_small), price_big=VALUES(price_big), position=VALUES(position), featured=VALUES(featured), hidden=VALUES(hidden) ";
	
	private static final String MENU_VIEW     = "SELECT * FROM teapop.menu WHERE menu_id = ?";
	
	private static final String MENU_VIEW_ALL = "SELECT * FROM teapop.menu";
	
	private static final String MENU_DELETE	  = "DELETE FROM teapop.menu WHERE menu_id = ?";
	
	public boolean createItem(MenuItem menuItem) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(MENU_CREATE);
			stmt.setInt(1, menuItem.getItemId());
			stmt.setString(2, menuItem.getItemCode());
			stmt.setInt(3, menuItem.getCatId());
			stmt.setString(4, menuItem.getName());
			stmt.setString(5, menuItem.getDesc());
			stmt.setString(6, menuItem.getPrice().getCurrency());
			stmt.setDouble(7, menuItem.getPrice().getRegular());
			stmt.setDouble(8, menuItem.getPrice().getSmall());
			stmt.setDouble(9, menuItem.getPrice().getLarge());
			stmt.setInt(10, menuItem.getDispPosition());
			stmt.setString(11, menuItem.getFeatured());
			stmt.setString(12, menuItem.getHidden());
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
				menuItem.setFeatured(rs.getString("featured"));
				menuItem.setHidden(rs.getString("hidden"));
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
				menuItem.setDispPosition(rs.getInt("position"));
				menuItem.setFeatured(rs.getString("featured"));
				menuItem.setHidden(rs.getString("hidden"));
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

	
}
