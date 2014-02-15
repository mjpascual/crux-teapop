package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Promo;
import com.upou.teapop.data.Specials;

public class SpecialsDao extends BaseDao {
	// CREATE
	public boolean createPromo(Promo promo) {
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

	// RETRIEVE
	public Specials retrievePromos() {

		Specials specials = new Specials();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Promo promo = new Promo();
				promo.setDesc(rs.getString("description"));
				promo.setName(rs.getString("name"));
				promo.setImage(rs.getString("image"));
				promo.setLink(rs.getString("link"));
				promo.setPromoId(rs.getInt("promoId"));
				specials.getPromos().add(promo);
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return specials;
	}

	public Promo retrievePromo(String promoId) {
		Promo promo = new Promo();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM promos WHERE id=" + promoId;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				promo.setDesc(rs.getString("description"));
				promo.setPromoId(rs.getInt("promoId"));
				promo.setName(rs.getString("name"));
				promo.setImage(rs.getString("image"));
				promo.setLink(rs.getString("link"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promo;
	}

	// UPDATE
	public boolean updatePromo(Promo promo) {
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
	public boolean deletePromo(String id) {
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
