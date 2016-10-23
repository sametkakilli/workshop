package objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connecttion.DatabaseConnection;

public class Products {
	private int productId;
	private int categoryId;
	private String productName;
	private int price;
	public int pric = 0;

	public Products() {

	}

	public Products(int productId, int categoryId, String productName, int price) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void addPrice(int price) {
		pric += price;
	}

	public List<Products> getAllProduct() {
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		Products products = null;
		List<Products> urunList = new ArrayList<Products>();

		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "SELECT * FROM workshop.product ;";
			System.out.println(mysql);
			ResultSet rs = stmt.executeQuery(mysql);
			while (rs.next()) {
				products = new Products(rs.getInt("productId"), rs.getInt("categoryId"), rs.getString("productName"), rs.getInt("price"));
				System.out.println(products.productName);
				urunList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return urunList;
	}
}
