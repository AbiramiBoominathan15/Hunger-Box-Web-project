<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.*, java.io.*, java.util.Base64, com.DAO.HungerImplements, com.model.Food"%>
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
/* .card{
display:flex;}
 */
.card {
	display: inline-block;
	width: 25%;
	margin: 10px;
}

-----------------------------
*, ::after, ::before {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	margin: 0 100px;
	background-color: #ffeae0;
}

.nav {
	width: 100%;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 30px 0;
}

.nav .logo h1 {
	font-weight: 600;
	font-family: sans-serif;
	color: black;
}

.nav b {
	color: #ff511c;
}

.nav ul {
	display: flex;
	list-style: none;
}

.nav ul li {
	margin-right: 30px;
}

.nav ul li a {
	text-decoration: none;
	color: black;
	font-weight: 500;
	font-family: sans-serif;
	font-size: 17px;
}

.nav .active::after {
	content: '';
	width: 50%;
	height: 3px;
	background-color: #ff511c;
	display: flex;
	position: relative;
	margin-left: 10px;
}

input {
	padding: 10px 20px;
	cursor: ponter;
	font-weight: 600;
}

.signin {
	background: transparent;
	border: none;
}

.signup {
	background-color: #ff511c;
	color: white;
	outline: none;
	border: none;
	border-radius: 5px;
}
</style>
<script>
    function incrementQuantity(foodId) {
        var quantityInput = document.getElementById('quantity_' + foodId);
        var quantityValue = parseInt(quantityInput.value);
        quantityInput.value = quantityValue + 1;
        document.getElementById('quantity_input_' + foodId).value = quantityValue + 1;
    }

    function decrementQuantity(foodId) {
        var quantityInput = document.getElementById('quantity_' + foodId);
        var quantityValue = parseInt(quantityInput.value);
        if (quantityValue > 1) {
            quantityInput.value = quantityValue - 1;
            document.getElementById('quantity_input_' + foodId).value = quantityValue - 1;
        }
    }
</script>

</head>
<body>
	<div class="nav">
		<div class="logo">
			<img src="Picture/logohungerbox.jpg">
			<h1>
				Hunger<b>Box</b>
			</h1>
		</div>
		<ul>
			<li><a class="active" href="#">Home</a></li>
			<li><a href="#">Menu</a></li>
			<li><a href="#">Service</a></li>
			<li><a href="#">AboutUs</a></li>
			<li><a href="#">Gallery</a></li>
		</ul>
		<div>
			<a class="signin" href="LoginPage.html">Sign In</a> <input
				class="signup" type="submit" value="Sign Up" name="signup">
		</div>
	</div>



	<h1>Hotel Details</h1>
	<%
	try {
		List<Food> foodlist = HungerImplements.read2();
		for (Food food : foodlist) {
			byte[] imageBytes = food.getFoodImage();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	%>
	<div class="card">
		<img src="data:image/jpeg;base64,<%=base64Image%>" alt="Book Cover"
			style="width: 200px; height: 200px;">
		<div class="card-details">
			<h2><%=food.getFoodCategories()%></h2>
			<h3><%=food.getFoodName()%></h3>
			<p>
			
				Price:
				<%=food.getFoodPrice()%></p>
			<!-- You can add more details here -->
			<div class="quantity-selector">
				<input type="button" value="-"
					onclick="decrementQuantity(<%=food.getFoodId()%>)"> <input
					type="text" id="quantity_<%=food.getFoodId()%>"
					name="quantity_<%=food.getFoodId()%>" value="0"> <input
					type="button" value="+"
					onclick="incrementQuantity(<%=food.getFoodId()%>)">
			</div>
			<div class="quantity-selector1">
				<input type="button" value="-"
					onclick="decrementQuantity(<%=food.getFoodId()%>)"> <input
					type="text" id="quantity_<%=food.getFoodId()%>"
					name="quantity_<%=food.getFoodId()%>" value="0"> <input
					type="button" value="+"
					onclick="incrementQuantity(<%=food.getFoodId()%>)">
			</div>

			<form action="" method="post">
				<input type="hidden" name="foodId" value="<%=food.getFoodId()%>">
				<input type="hidden" id="quantity_input_<%=food.getFoodId()%>"
					name="quantity" value="0"> <input type="submit"
					value="Add to Cart">
			</form>

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