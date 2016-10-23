<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.KategoriServlet"%>
<%@page import="objects.*"%>
<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% List<Kategori> kategoriList=new KategoriDaoImp().getProducts();
request.setAttribute("kategoriList", kategoriList);
%>


<c:forEach items="${kategoriList}" var="kategori">
	<ul class="menu1">
		<li><div class="shadow" >
		<img src="images/categories/${kategori.getCategoryId()}.jpg" alt="" />
				<span class="baslik"></span> <span class="link"><a href="urunlerservlet?katid=${kategori.getCategoryId()}">${kategori.getCategoryName()}</a></span>
			</div></li>
	</ul>
</c:forEach>
<jsp:include page="footer.jsp"></jsp:include>