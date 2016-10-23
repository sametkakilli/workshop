package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Customer;
import objects.Sepet;
import connecttion.DatabaseConnection;

/**
 * Servlet implementation class SiparisServlet
 */
@WebServlet("/siparisServlet")
public class SiparisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SiparisServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Sepet> sepet = null;
		sepet = (List<Sepet>) request.getSession().getAttribute("sepet");
		Customer customer = null;
		customer = (Customer) request.getSession().getAttribute("customer");
		DatabaseConnection dbc = new DatabaseConnection();
		Statement stmt = null;
		try {
			stmt = dbc.setConnection().createStatement();
			String mysql;
			for (Sepet pro : sepet) {
				mysql = "insert into workshop.saledproduct(productId,usrId,categoryId,productname,price) values('" + pro.getProductId() + "','" + customer.getId() + "','" + pro.getCategoryId() + "','" + pro.getProductName() + "','" + pro.getSaledProductPrice() + "')";
				System.out.println(mysql);
				stmt.executeUpdate(mysql);
			}
			dbc.closeConnection();
			sepet.clear();
			request.setAttribute("basari", "Sayýn" + customer.getName() + "  sipariþiniz alýnmýþtýr");
			request.getRequestDispatcher("./customer.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
