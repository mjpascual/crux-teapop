package com.upou.teapop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Category;
import com.upou.teapop.util.StringHelper;

public class CategoryDao extends BaseDao {
	
	private static final String CATEGORY_CREATE   = "INSERT INTO teapop.category (category_id, main_category, name, description, image_name, show_sml, position) " +
												    "VALUES (?, ?, ?, ?, ?, ?, ?) " +
												    "ON DUPLICATE KEY UPDATE category_id=VALUES(category_id), main_category=VALUES(main_category), name=VALUES(name),  description=VALUES(description), image_name=VALUES(image_name), show_sml=VALUES(show_sml), position=VALUES(position)";

	private static final String CATEGORY_VIEW     = "SELECT * FROM teapop.category WHERE category_id = ?";
	
	private static final String CATEGORY_VIEW_ALL = "SELECT * FROM teapop.category";
	
	private static final String CATEGORY_DELETE   = "DELETE FROM teapop.category WHERE category_id = ?";
	
	public boolean createCategory(Category category) throws SQLException, IOException {
		boolean result = false;
		
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(CATEGORY_CREATE);
			
			stmt.setInt(1, StringHelper.stringToInt(category.getCategoryId()));
			stmt.setString(2, category.getMain());
			stmt.setString(3, category.getName());
			stmt.setString(4, category.getDesc());
			stmt.setString(5,  category.getImage());
			stmt.setBoolean(6, category.getShowSML());
			stmt.setInt(7, Integer.parseInt(category.getDisp()));

			stmt.executeUpdate();
			result = true;
		
		return result;
	}

	public Category retrieveCategory(String categoryId) throws NumberFormatException, SQLException {
		Category category = new Category();
		
			Connection conn = createConnection();

			PreparedStatement stmt = conn.prepareStatement(CATEGORY_VIEW);
			stmt.setInt(1, Integer.parseInt(categoryId));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				category.setCategoryId(String.valueOf(rs.getInt("category_id")));
				category.setDesc(rs.getString("description"));
				category.setName(rs.getString("name"));
				category.setMain(rs.getString("main_category"));
				category.setShowSML(rs.getBoolean("show_sml"));
				category.setDisp(String.valueOf(rs.getInt("position")));
				category.setImage(rs.getString("image_name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		return category;
	}

	public List<Category> retrieveCategories() {

		List<Category> categories = new ArrayList<Category>();
		try {
			Connection conn = createConnection();
			
			PreparedStatement stmt = conn.prepareStatement(CATEGORY_VIEW_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(String.valueOf(rs.getInt("category_id")));
				category.setDesc(rs.getString("description"));
				category.setName(rs.getString("name"));
				category.setMain(rs.getString("main_category"));
				category.setDisp(String.valueOf(rs.getInt("position")));
				category.setShowSML(rs.getBoolean("show_sml"));
				category.setImage(rs.getString("image_name"));
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
	
	public boolean deleteCategory(String id) throws NumberFormatException, SQLException {
		boolean result = false;
	
			Connection conn = createConnection();
			
			PreparedStatement stmt = conn.prepareStatement(CATEGORY_DELETE);
			stmt.setInt(1,Integer.parseInt(id));
			stmt.executeUpdate();

			result = true;
			
		return result;
	}
}
