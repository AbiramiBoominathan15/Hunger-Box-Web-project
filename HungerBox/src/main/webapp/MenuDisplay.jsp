<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*, java.io.*, java.util.Base64, com.DAO.HungerImplements, com.model.Food" %>
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
	background-color: yellow;
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
	background-color: blue; /* Changed to blue */
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
.card{
display:flex;}
</style>
</head>
<body>

	<h1>Hotel Details</h1>
		<%
		try{
		List<Food> foodlist = HungerImplements.read2();
			for (Food food : foodlist) {
                byte[] imageBytes = food.getFoodImage(); // Assuming you have a method to retrieve book cover as byte array
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
    %>
                <div class="card">
                    <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Book Cover" style="width:200px; height:200px;">
                    <div class="card-details">
                        <h3><%= food.getFoodName() %></h3>
                        <p>Price: <%= food.getFoodPrice()%></p>
                        <!-- You can add more details here -->
                    </div>
                </div>
    <%
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    %>


</body>
</html>