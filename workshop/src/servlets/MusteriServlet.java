package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.Customer;
import connecttion.DatabaseConnection;

@WebServlet("/musteriServlet")
public class MusteriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MusteriServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim().toLowerCase();
		String surname = request.getParameter("surname").trim().toLowerCase();
		String password = request.getParameter("password").trim().toLowerCase();

		Connection con = null;
		Statement stmt = null;
		DatabaseConnection db = new DatabaseConnection();
		System.out.println("setconnection");
		con = db.setConnection();
		Customer customer = null;
		String name_db = null;
		String surname_db = null;
		String password_db = null;
		int id_db = 0;
		try {
			String mysql;
			stmt = con.createStatement();
			mysql = "SELECT * FROM workshop.customer where name='" + name + "' and surname='" + surname + "' and password='" + password + "';";
			System.out.println(mysql);
			ResultSet rs = stmt.executeQuery(mysql);
			while (rs.next()) {
				name_db = rs.getString("name");
				surname_db = rs.getString("surname");
				password_db = rs.getString("password");
				customer = new Customer(rs.getInt("usrId"), rs.getString("name"), rs.getString("surname"), rs.getString("adress"), rs.getString("telephone"), rs.getString("gmail"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		if (name_db != null && name.equalsIgnoreCase(name_db) && surname.equalsIgnoreCase(surname_db) && password.equalsIgnoreCase(password_db)) {
			HttpSession oturum = request.getSession();
			oturum.setAttribute("customer", customer);
			response.sendRedirect("./home.jsp");
		} else {
			System.out.println(name + " " + surname + " " + password);
			response.sendRedirect("./user.jsp");
		}

	}

}
