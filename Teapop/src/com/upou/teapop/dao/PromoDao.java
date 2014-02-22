package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Promo;

public class PromoDao extends BaseDao {
	
	private static final String PROMO_CREATE   = "INSERT INTO teapop.promo (promo_id, promo_code, name, description, image_name) " +
												 "VALUES (?, ?, ?, ?, ?) " +
												 "ON DUPLICATE KEY UPDATE promo_id=VALUES(promo_id), promo_code=VALUES(promo_code), name=VALUES(name), description=VALUES(description), image_name=VALUES(image_name) ";

	private static final String PROMO_VIEW     = "SELECT * FROM teapop.promo WHERE promo_id = ?";
	
	private static final String PROMO_VIEW_ALL = "SELECT * FROM teapop.promo";
	
	private static final String PROMO_DELETE   = "DELETE FROM teapop.promo WHERE promo_id = ?";
	
	public boolean createPromo(Promo promo) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(PROMO_CREATE);

			stmt.setInt(1, promo.getPromoId());
			stmt.setString(2, promo.getPromoCode());
			stmt.setString(3, promo.getName());
			stmt.setString(4, promo.getDesc());
			stmt.setString(5, promo.getImage());
	
			stmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Promo retrievePromo(int promoId) {
		Promo promo = new Promo();
		try {
			
			Connection conn = createConnection();

			PreparedStatement stmt = conn.prepareStatement(PROMO_VIEW);
			stmt.setInt(1, promoId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				promo.setPromoCode(rs.getString("promo_code"));
				promo.setDesc(rs.getString("description"));
				promo.setName(rs.getString("name"));
				promo.setImage(rs.getString("image_name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promo;
	}

	public List<Promo> retrieveCategories() {

		List<Promo> categories = new ArrayList<Promo>();
		try {
			Connection conn = createConnection();
			
			PreparedStatement stmt = conn.prepareStatement(PROMO_VIEW_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Promo promo = new Promo();
				promo.setPromoId(rs.getInt("promo_id"));
				promo.setPromoCode(rs.getString("promo_code"));
				promo.setDesc(rs.getString("description"));
				promo.setName(rs.getString("name"));
				promo.setImage(rs.getString("image_name"));
				categories.add(promo);
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}
	
	public boolean deletePromo(int id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			
			PreparedStatement stmt = conn.prepareStatement(PROMO_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}