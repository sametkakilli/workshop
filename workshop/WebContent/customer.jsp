<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.KategoriServlet"%>
<%@page import="objects.*"%>
<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%if(request.getSession().getAttribute("sepet")!=null){
	List<Sepet> sepet = null;
	int price = 0;
	sepet = (List<Sepet>) request.getSession().getAttribute("sepet");
%>
<table>
	<form method="post" action="siparisServlet">
		<%
			for (Sepet pro : sepet) {
		%>
		<tr>
			<td>
			<th>Ürün Adı:</th>
			</td>
			<td><%=pro.getProductName()%></td>
			<td>
			<th>Ürün Fiyatı:</th>
			</td>
			<td><%=pro.getSaledProductPrice()%></td>
		</tr>
		<%
			price += pro.getSaledProductPrice();
			}
		if(price!=0){
		%>
		<tr>
			<td>
			<th>Toplam Fiyat:</th>
			</td>
			<td><%=price%>TL</td>
		</tr>
		<tr>
			<td>
			<th><input type="submit" value="Satın Al"></th>
			</td>
		</tr>
	</form>
</table>

<%}}
	Customer customer = (Customer) request.getSession().getAttribute("customer");
	List<Sepet> oldCartList = new SepetDaoImp().getBeforeProduct(customer.getId());
	if (oldCartList != null) {
%>
<table>
	<tr>
		<td colspan="2"><center><th>Önceki Alışverişler</th></center></td></tr>
<%
	for (Sepet cart : oldCartList) {
%>
<tr>
<td>
		<th>Ürün Adı:</th>
		</td>
		<td><%=cart.getProductName()%></td>
<td>
		<th>Ürün Fiyatı:</th>
		</td>
		<td><%=cart.getSaledProductPrice()%></td>
</tr>
<%
	}
%>
</table>
<%
	}
%>

<jsp:include page="footer.jsp"></jsp:include>