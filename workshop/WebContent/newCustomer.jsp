<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kayıt</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">

function isValid(frm)
{
    var name = frm.name.value;
    var surname = frm.surname.value;
    var adress = frm.adress.value;
    var phone = frm.phone.value;
    var email = frm.email.value;
    var password1 = frm.password1.value;
    var password2 = frm.password2.value;
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
    if ( adress==null || adress=="" )
    {
        alert("Kullanıcı adresi boş olamaz");
        return false;
    }
    if ( phone==null || phone=="" )
    {
        alert("Kullanıcı telefonu boş olamaz");
        return false;
    }
    if ( email==null || email=="" )
    {
        alert("Kullanıcı emaili boş olamaz");
        return false;
    }
    if ( password1 == null || password1 == "" || password2 == null || password2 == "")
    {
        alert("Şifreyi boş bırakmayın");
        return false;
    }
    if ( !(password1 == password2) )
    {
        alert("Şifreler eşleşmiyor");
        return false;
    }
    return true;
}

</script>
</head>
<body bgcolor='#33CCFA'>
<table>
<form method="post" action='musteriKayitServlet' onsubmit="return isValid(this)">
<tr><td>Kullanici ismi </td><td><input type='text' name="name"></td></tr>
<tr><td>Kullanici soyismi </td><td><input type='text' name="surname"></td></tr>
<tr><td>Kullanici Adresi </td><td><input type='text' name="adress"></td></tr>
<tr><td>Kullanici Telefonu </td><td><input type='text' name="phone"></td></tr>
<tr><td>Kullanici Emaili </td><td><input type='text' name="email"></td></tr>
<tr><td>Parola </td><td><input type="password" name="password1"></td></tr>
<tr><td>Parola Tekrar </td><td><input type="password" name="password2"></td></tr>
<tr><td><input type="submit" value="Kaydet"></td></tr>
</form>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>