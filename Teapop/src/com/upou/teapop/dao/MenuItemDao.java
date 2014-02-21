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

public class MenuItemDao extends BaseDao {

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

	
}
