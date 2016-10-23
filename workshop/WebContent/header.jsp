<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="objects.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>workshop</title>
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<!-- start header -->
	<div id="header">
		<div id="logo">
			<h1>
				<a href="#">Alışveriş </a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<a href="home.jsp" accesskey="1" title="">Anasayfa</a></li>
				<li><a href="#" accesskey="2" title="">Hakkımızda</a></li>
				<li><a href="#" accesskey="3" title="">İletişim</a></li>
				<% 
				Customer customer=null;
				customer=(Customer)request.getSession().getAttribute("customer");
				if(customer!=null){%>
				<%if(customer.getName().equalsIgnoreCase("admin")){ %>
				<li><a href="admin.jsp" accesskey="4" title="">${customer.name}</a></li>
				<%} %>
				<%if(!customer.getName().equalsIgnoreCase("admin")){ %>
				<li><a href="customer.jsp" accesskey="4" title="">${customer.name}</a></li>
				<%} %>
				<li><a href="logoutServlet" accesskey="5" title="">Çıkış</a></li>
				<%} else{%>
				<li><a href="user.jsp" accesskey="4" title="">Giriş</a></li>
				<%} %>
			</ul>
		</div>
	</div>
	<!-- end header -->
	<div id="gallery">
		<div id="top-photo">
			<p>
				<a href="#"><img src="images/img8.png" alt="" width="830"
					height="300" /></a>
			</p>
		</div>
	</div>
	<div id="page">