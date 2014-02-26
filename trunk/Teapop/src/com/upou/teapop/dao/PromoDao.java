package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Promos;

public class PromoDao extends BaseDao {

	private static final String PROMO_CREATE = "INSERT INTO teapop.promo (promo_code, name, description, image_name) "
			+ "VALUES (?, ?, ?, ?) ";

	private static final String PROMO_VIEW = "SELECT * FROM teapop.promo WHERE promo_id = ?";

	private static final String PROMO_VIEW_ALL = "SELECT * FROM teapop.promo";

	private static final String PROMO_DELETE = "DELETE FROM teapop.promo WHERE promo_id = ?";

	private static final String PROMO_EDIT = "UPDATE teapop.promo SET promo_code = ?, name = ?, description = ? WHERE promo_id = ?";

	public boolean createPromo(Promo promo) throws SQLException {
		boolean result = false;
		Connection conn = createConnection();

		PreparedStatement stmt = conn.prepareStatement(PROMO_CREATE);

		stmt.setString(1, promo.getPromoCode());
		stmt.setString(2, promo.getName());
		stmt.setString(3, promo.getDesc());
		stmt.setString(4, promo.getImage());

		stmt.executeUpdate();
		result = true;
		return result;
	}

	public boolean editPromo(Promo promo) throws SQLException {
		boolean result = false;
		Connection conn = createConnection();

		PreparedStatement stmt = conn.prepareStatement(PROMO_EDIT);

		stmt.setString(1, promo.getPromoCode());
		stmt.setString(2, promo.getName());
		stmt.setString(3, promo.getDesc());
		stmt.setInt(4, promo.getPromoId());

		stmt.executeUpdate();
		result = true;
		return result;
	}

	public Promo retrievePromo(int promoId) throws SQLException {
		Promo promo = new Promo();

		Connection conn = createConnection();

		PreparedStatement stmt = conn.prepareStatement(PROMO_VIEW);
		stmt.setInt(1, promoId);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			promo.setPromoCode(rs.getString("promo_code"));
			promo.setDesc(rs.getString("description"));
			promo.setName(rs.getString("name"));
			promo.setImage(rs.getString("image_name"));
			promo.setPromoId(rs.getInt("promo_id"));
		}
		conn.close();
		stmt.close();
		rs.close();

		return promo;
	}

	public List<Promo> retrieveCategories() throws SQLException {

		List<Promo> categories = new ArrayList<Promo>();
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


		return categories;
	}

	public boolean deletePromo(int id) throws SQLException {
		boolean result = false;
		
		Connection conn = createConnection();

		PreparedStatement stmt = conn.prepareStatement(PROMO_DELETE);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		result = true;
		return result;
	}

	// RETRIEVE
	public Promos retrievePromos() {

		Promos promos = new Promos();
		try {
			Connection conn = createConnection();

			// get category info
			PreparedStatement stmt = conn.prepareStatement(PROMO_VIEW_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Promo promo = new Promo();
				promo.setDesc(rs.getString("description"));
				promo.setName(rs.getString("name"));
				promo.setImage(rs.getString("image_name"));
				promo.setPromoId(rs.getInt("promo_id"));
				promo.setPromoCode(rs.getString("promo_code"));
				promos.getPromos().add(promo);
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return promos;
	}
}
