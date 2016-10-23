package objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connecttion.DatabaseConnection;

public class SepetDaoImp implements SepetDao {

	@Override
	public Sepet getProduct(int productId, int customerId) {
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		Sepet sepet = null;
		int categoryId = 0;
		int saledProductPrice = 0;
		String productName = null;

		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "SELECT * FROM workshop.product where productId='" + productId + "';";
			System.out.println(mysql);
			ResultSet rs = stmt.executeQuery(mysql);

			while (rs.next()) {
				categoryId = rs.getInt("categoryId");
				productName = rs.getString("productName");
				saledProductPrice = rs.getInt("price");
			}
			sepet = new Sepet(productId, customerId, categoryId, productName, saledProductPrice);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return sepet;
	}

	public List<Sepet> getBeforeProduct(int customerId) {
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		Sepet sepet = null;
		List<Sepet> sepetList = new ArrayList<Sepet>();

		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "SELECT * FROM workshop.saledproduct where usrId='" + customerId + "';";
			System.out.println(mysql);
			ResultSet rs = stmt.executeQuery(mysql);

			while (rs.next()) {
				sepet = new Sepet(rs.getInt("productId"), rs.getInt("usrId"), rs.getInt("categoryId"), rs.getString("productName"), rs.getInt("price"));
				sepetList.add(sepet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return sepetList;
	}
}
