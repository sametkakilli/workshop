package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connecttion.DatabaseConnection;

@WebServlet("/adminservlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String deletedProductId = request.getParameter("deletedproductId");
		String productName = request.getParameter("newProductName");
		String categoryId = request.getParameter("category");
		String productPrice = request.getParameter("newProductPrice");
		if (deletedProductId != null) {
			deleteProduct(deletedProductId);
			response.sendRedirect("admin.jsp");
		} else {
			addProduct(productName, categoryId, productPrice);
			System.out.println("buradan geçti");
			response.sendRedirect("admin.jsp");
		}
	}

	public void deleteProduct(String productId) {
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "DELETE  FROM workshop.product where ProductId='" + productId + "' ;";
			System.out.println(mysql);
			stmt.executeUpdate(mysql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
	}

	public void addProduct(String productName, String categoryId, String productPrice) {
		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		con = db.setConnection();
		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "insert into workshop.product(categoryId,productname,price) values('" + categoryId + "','" + productName.toLowerCase() + "','" + productPrice + "') ;";
			System.out.println(mysql);
			stmt.executeUpdate(mysql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
	}

}
