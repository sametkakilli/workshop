package objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connecttion.DatabaseConnection;

public class KategoriDaoImp implements KategoriDao {

	@Override
	public List<Kategori> getProducts() {
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		Kategori kategori = null;
		List<Kategori> kategoriList = new ArrayList<Kategori>();

		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "SELECT * FROM workshop.category;";
			System.out.println(mysql);
			ResultSet rs = stmt.executeQuery(mysql);
			System.out.println("here");

			while (rs.next()) {
				kategori = new Kategori(rs.getInt("categoryId"), rs.getString("categoryName"));
				kategoriList.add(kategori);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return kategoriList;
	}

}
