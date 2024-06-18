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
	background-color: blue;
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

	<h1>Customer Details</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Phonenumber</th>
			<th>password</th>
			<th>city</th>
			<th>mailId</th>
			<th colspan="2">Actions</th>
		</tr>
		<%
		List<UserDetails> list = (ArrayList<UserDetails>) request.getAttribute("list");
		if (list != null) {
			for (UserDetails user : list) {
		%>
		<tr>






			<td><%=user.getName()%></td>
			<td><%=user.getPhoneNumber()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getCity()%></td>
			<td><%=user.getMailId()%></td>
			<td><input type="hidden" name="emailId"
				value="<%=user.getName()%>"> <a
				href="update.html?editId=<%=user.getPhoneNumber()%>">
					<button type="button">Update</button>
			</a></td>
<%-- 			<td>
				<form action="UserDeleteServlet" method="post">
			<input type="hidden" name="action" value="Delete"> <input
						type="hidden" name="delete" value="<%=user.getName()%>">
					<button type="submit" title="delete">Delete</button>
				</form>
			</td>
 --%>			<%
			}
			}
			%>
		
	</table>
</body>
</html>