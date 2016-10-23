package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Customer;
import objects.Sepet;
import objects.SepetDaoImp;

@WebServlet("/sepetServlet")
public class SepetServlet extends HttpServlet {
	int sepet = 0;
	List<Sepet> cartList = new ArrayList<Sepet>();
	private static final long serialVersionUID = 1L;

	public SepetServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		int customerId = customer.getId();
		Sepet sepet = new SepetDaoImp().getProduct(productId, customerId);
		cartList.add(sepet);
		request.getSession().setAttribute("sepet", cartList);
		request.getRequestDispatcher("urunlerservlet?katid=" + sepet.getCategoryId() + "").forward(request, response);
	}
}
