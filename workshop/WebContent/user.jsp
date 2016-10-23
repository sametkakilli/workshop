<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.KategoriServlet"%>
<%@page import="objects.Kategori"%>
<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">

function isValid(frm)
{
    var name = frm.name.value;
    var surname = frm.surname.value;
    var password = frm.password.value;
    if ( name==null || name=="" )
    {
        alert("Kullanıcı adı boş olamaz");
        return false;
    }
    if ( surname==null || surname=="" )
    {
        alert("Kullanıcı soyadı boş olamaz");
        return false;
    }
    if ( password == null || password == "" )
    {
        alert("Şifreyi boş bırakmayın");
        return false;
    }
}

</script>
<% String message=null;
message=(String)request.getAttribute("basari");
if(message!=null){
	out.print(message);
}

%>

<table><tr>
<form action="musteriServlet" method="post" onsubmit="return isValid(this)">
<td>Kullanıcı Adı</td><td><input type="text" name="name" style="border-color: orange;"></td></tr>
<tr><td>Kullanıcı Soydı</td><td><input type="text" name="surname" style="border-color: orange;" ></td></tr>
<tr><td>Kullanıcı Parolası</td><td><input type="password" name="password" style="border-color: orange;"></td></tr>
<tr><td colspan="2"><center><input type="submit" value="Giriş" style="border-color: orange;"></center></form></td></tr>
<tr><td colspan="2"><form action="newCustomer.jsp" method="post" ><input type="submit" value="Kayıt Ol" style="border-color: orange;"></form></td></tr>
</table>


<jsp:include page="footer.jsp"></jsp:include>