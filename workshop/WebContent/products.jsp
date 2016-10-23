<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.KategoriServlet"%>
<%@page import="objects.*"%>
<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Customer customer=null;
	customer=(Customer)request.getSession().getAttribute("customer");
	if (customer!= null) {
		List<Sepet> sepet = null;
		sepet = (List<Sepet>) request.getSession().getAttribute("sepet");
		if (sepet != null) {
			int price = 0;
			for (Sepet product : sepet) {
				price += product.getSaledProductPrice();
			}
%>
<table>
	<tr>
		<td><%=price%>TL</td>
	</tr>
	<tr>
		<td><a href="customer.jsp"><img src="images/cart.gif" alt=""/></a></td>
	</tr>
</table>
<%
	}
	}
%>


<c:forEach items="${urunList}" var="urun">
	<ul class="menu1">
		<li><div class="shadow">
				<center>
					<img src="images/products/${urun.productId}.png" alt="" />
				</center>
				<span class="baslik"></span> <span class="link"><a>${urun.productName}
				</br>${urun.price}
				</a></span>
				<%
					if (request.getSession().getAttribute("customer") != null) {
				%>
				<center>
					<a href="sepetServlet?productId=${urun.productId}">Sepete Ekle</a>
				</center>
				<%
			}
				%>
			</div></li>
	</ul>
</c:forEach>
<jsp:include page="footer.jsp"></jsp:include>