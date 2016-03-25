<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.simpleprogrammer.User"%>
<%@ page import=" java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Product purchase</h1>
<form method="get">
<c:forEach items="${list}" var="product">
    <tr>      
       
        <td>${product.name}</td>  
    </tr>
    </br>
</c:forEach>
</form>
</body>
</html>