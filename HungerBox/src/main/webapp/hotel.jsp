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
	background-color:#ececec;
}
h1 {
	text-align: center;
	color: #142d4c;
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
	background-color: #142d4c; 
	background-color: #142d4c; 	
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

#addBtn{
	padding-left: 80%;
padding-bottom: 20px;
}
</style>
</head>
<body>
	<h1>Hotel Details</h1>
	
	<table border="1">
		<tr>
		<th>HotelId</th>
			<th>HotelName</th>
			<th>HotelLocation</th>
			<th>Phonenumber</th>
			<th>Email</th>
			<th>Password</th>
			<th>Status</th>
			<th colspan="2">Actions</th>
		</tr>
		<%
		List<Hotel> list1 = (ArrayList<Hotel>) request.getAttribute("list");
		if (list1 != null) {
			for (Hotel hotel : list1) {
		%>
		<tr>
		<td><%=hotel.getHotelId() %></td>
		<td><%=hotel.getHotelName()%></td>
			<td><%=hotel.getHotelLocation()%></td>
			<td><%=hotel.getHotelPhoneNumber()%></td>
			<td><%=hotel.getHotelEmail() %></td>
			<td><%=hotel.getHotelPassword() %></td>
			<td><%=hotel.getHotelStatus() %></td>
			
						<td>
<form action="AdminApproved" method="post">
                    <input type="hidden" name="hotelId"
                        value="<%=hotel.getHotelId() %>"> 
                        <select
                        name="approved">
                        <option>Select</option>
                        <option value="no">no</option>
                        <option value="yes">yes</option>
                    </select><input type="submit" name="approved" value="update"
                        style="margin: 0 15px">
                </form></td>
					
			<td>
			<form action="AdminHotelDelete" method="post">
					<input type="hidden" name="action" value="Delete"> <input
						type="hidden" name="delete" value="<%=hotel.getHotelName()%>">
					<button type="submit" title="delete">Delete</button>
				</form>
			</td>
			</td>
			
<%-- 			<td><input type="hidden" name="location"
				value="<%=hotel.getHotelName()%>"> <a
				href="updateHotel.html?editId=<%=hotel.getHotelName()%>">
					<button type="button">Update</button>
			</a></td>
			<td>
 --%> 					
			<%
			}
			}
			%>
		</tr>
	</table>
									
</body>
</html>



