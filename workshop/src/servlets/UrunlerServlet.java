package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Products;
import connecttion.DatabaseConnection;

@WebServlet("/urunlerservlet")
public class UrunlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String katId = request.getParameter("katid");
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		Products products = null;
		List<Products> urunList = new ArrayList<Products>();

		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "SELECT * FROM workshop.product where categoryId='" + katId + "' ;";
			System.out.println(mysql);
			ResultSet rs = stmt.executeQuery(mysql);
			while (rs.next()) {
				products = new Products(rs.getInt("productId"), rs.getInt("categoryId"), rs.getString("productName"), rs.getInt("price"));
				urunList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		request.setAttribute("urunList", urunList);
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

}
