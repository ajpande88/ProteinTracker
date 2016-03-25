<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Insert" method="post">
		<table>
		<tr>
				<td>Produt ID :</td>
				<td><input type="text" name="product_id" /></td>
			</tr>
		     <tr>
				<td>Produt Name :</td>
				<td><input type="text" name="product_name" /></td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td><input type="text" name="product_desc" /></td>
			</tr>
			<tr>
				<td>Product Quantity</td>
				<td><input type="text" name="product_quantity" /></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="password" name="product_price" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Insert"></td>
			</tr>
		</table>
	</form>
</body>
</html>