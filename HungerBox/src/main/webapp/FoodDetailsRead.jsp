<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-color: black;
}

h1 {
	text-align: center;
	color: blue;
}

a {
	text-decoration: none;
	color: black;
}

table {
	margin: 0 auto;
	border-collapse: collapse;
	width: 80%;
}

th {
	background-color: skyblue; 
	color: white;
}

td {
	background-color: violet;
	color: white;
}

.footer {
	text-align: center;
}

.footer button {
	margin: 10px;
}

.search-bar {
	text-align: center;
	margin-bottom: 20px;
}

.search-bar input[type="text"] {
	padding: 8px;
	width: 30%;
	border-radius: 5px;
	border: 1px solid #ccc;
}
</style>
</head>
<body>

	<h1>FoodDetails</h1>
	<table border="1">
		<tr>
			<th>HotelId</th>
			<th>Image</th>
			<th>Name</th>
			<th>Price</th>
			<th>Catagories</th>
		    <th colspan="2">Actions</th>
		</tr>
		<%
		List<Food> list = (ArrayList<Food>) request.getAttribute("list");
		if (list != null) {
			for (Food food : list) {
		%>
		<tr>
			<td><%=food.getHotelId()%></td>
						<td><%=food.getFoodImage()%></td>
						<td><%=food.getFoodName()%></td>
					     <td><%=food.getFoodPrice()%></td>
						<td><%=food.getFoodCategories()%></td>	
			<%
			}
			}
			%>
		
	</table>
</body>
</html>