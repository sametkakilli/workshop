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

import objects.Kategori;
import connecttion.DatabaseConnection;

@WebServlet("/kategoriServlet")
public class KategoriServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.setAttribute("kategoriList", kategoriList);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
