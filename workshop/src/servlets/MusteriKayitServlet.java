package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connecttion.DatabaseConnection;

/**
 * Servlet implementation class MusteriKayitServlet
 */
@WebServlet("/musteriKayitServlet")
public class MusteriKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MusteriKayitServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String userSurname = request.getParameter("surname");
		String userAdress = request.getParameter("adress");
		String userPhone = request.getParameter("phone");
		String userEmail = request.getParameter("email");
		String userPassword1 = request.getParameter("password1");
		String userPassword2 = request.getParameter("password2");

		DatabaseConnection dbc = new DatabaseConnection();
		Statement stmt = null;
		try {
			stmt = dbc.setConnection().createStatement();
			String mysql;
			mysql = "insert into workshop.customer(name,surname,adress,telephone,gmail,password) values('" + userName.toLowerCase() + "','" + userSurname.toLowerCase() + "','" + userAdress.toLowerCase() + "','" + userPhone + "','" + userEmail + "','" + userPassword1 + "')";
			System.out.println(mysql);
			stmt.executeUpdate(mysql);
			dbc.closeConnection();
			request.setAttribute("basari", "Hoþgeldin " + userName + "  lütfen giriþ yap");
			request.getRequestDispatcher("./user.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
