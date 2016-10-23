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
	Products products=new Products();
	List<Products> urunList=products.getAllProduct();
	request.setAttribute("urunList", urunList);
%>
<table>
  <tr>
    <th>Ürün Adı</th>
    <th>Ürün Fiyatı</th>
  </tr>
<c:forEach items="${urunList}" var="urun">
	<tr>
    	<td>${urun.getProductName()}</td>
    	<td>${urun.getPrice()} TL</td>
    	<td><a href="adminservlet?deletedproductId=${urun.productId}">Ürün Sil</a></td>
  	</tr>
		
</c:forEach>
</table>
	<table>
  <tr>
    <th>Ürün Adı</th>
    <th>Ürün Kategorisi</th>
    <th>Ürün Fiyatı</th>
  </tr>
  <tr><form action="adminservlet" method="post" >
    <td><input type="text" name="newProductName"></td>
    <td>
    	<select name="category">
    		<option value="1">Et Urunleri</option>
    		<option value="2">Meyve Sebze</option>
    		<option value="3">Sut Urunleri</option>
    		<option value="4">Unlu Mamuller</option>
    </td>
    <td><input type="text" name="newProductPrice"></td>
    <td><input type="submit" value="Kaydet"></td>
  	</form>
  </tr>
</table>

<jsp:include page="footer.jsp"></jsp:include>