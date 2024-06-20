<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.*, java.io.*, java.util.Base64, com.DAO.HungerImplements, com.model.Food"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.*"%>
<%@ page import="com.model.Hotel"%>
<%@ page import="com.model.Food"%>

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
/* .card{
display:flex;}
 */
.card {
	display: inline-block;
	width: 25%;
	margin: 10px;
}

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
	cursor: pointer;
	font-weight: 600;
}
.view {
    padding: 10px 10px;
    cursor: ponter;
    width: 24%;
    font-weight: 600;
}.signin {
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
function checkAvailability(searchValue, hour) {
    if (searchValue.toLowerCase() === 'breakfast' && hour >= 12) {
        alert('Breakfast is not available after 12 PM.');
        return false;
    } else if (searchValue.toLowerCase() === 'lunch' && (hour < 12 || hour >= 17)) {
        alert('Lunch foods are not available before 12 PM and after 5 PM.');
        return false;
    } else if (searchValue.toLowerCase() === 'dinner' && (hour < 12 || hour >= 17)) {
        alert('Dinner foods are not available after 5 PM.');
        return false;
    } else if (searchValue.toLowerCase() === 'breakfast' && (hour < 6 || hour >= 12)) {
        alert('Breakfast foods are not available before 6 AM and after 12 PM.');
        return false;
    }
    return true;
}
function addToCartClicked(foodId, price) {
    var quantity = parseInt(document.getElementById("quantity_" + foodId).value);
    var totalPrice = quantity * price;
    var currentOverallPrice = parseFloat(document.getElementById("overallPrice").innerText);
    var newOverallPrice = currentOverallPrice + totalPrice;
    document.getElementById("overallPrice").innerText = newOverallPrice.toFixed(2);
}

</script>

</head>
<body>

	<div class="nav">
		<div class="logo">

			Much<b>Mate</b>
			</h1>
		</div>
		<ul>
			<li><a class="active" href="#">Home</a></li>
			<li><a href="Aboutus.html">AboutUs</a></li>
			<li><a href="Contactpage.html">Contact</a></li>
			<!-- 			<li><a href="#">Cart</a></li>
 -->
		</ul>
<%-- 		<form action="" method="post"
			onsubmit="return checkAvailability(this.querySelector('input[type=text]').value, <%=java.time.LocalTime.now().getHour()%>)">
			<input type="text" placeholder="Search..."
				style="padding: 8px; border-radius: 5px; border: 1px solid #ccc;">
			<input type="submit" value="Search">
		</form>
 --%>		
 <form action="AddCart" method="get">
			<input type="submit"  name="action" value="viewCart">
		</form>
	</div>
<!-- 	<h1>Food Details</h1>
 -->	

	<%
	try {
		List<Food> foodlist = HungerImplements.read2();
		for (Food food : foodlist) {
			byte[] imageBytes = food.getFoodImage();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			System.out.println("food_id = " + food.getFoodId());
			System.out.println("food_id = " + food.getFoodId());
	%>
	<div class="card">
		<form action="AddCart" method="post">
			<img src="data:image/jpeg;base64,<%=base64Image%>" alt="Book Cover"
				style="width: 200px; height: 200px;">
			<div class="card-details">
<%-- 				<h1><%=food.getHotelName()%></h1>
 --%>				
<%-- 								<h1><%=food.getHotelId()%></h1>
 --%> 				
 <input type="hidden" value="<%=food.getHotelId()%>" name="hotelid">
 
<%-- 				<h2 style="color: red;">
 					FoodId:
					<%=food.getFoodId()%></h2>
 --%> 				
 <h2><%=food.getFoodCategories()%></h2>
				<h3><%=food.getFoodName()%></h3>
				<p>
					Price:
					<%=food.getFoodPrice()%></p>
				<input type="hidden" value="<%=food.getFoodPrice()%>" name="price">
				<p
					class="<%=food.getAvailability().equalsIgnoreCase("Available") ? "available" : "unavailable"%>">
					<%=food.getAvailability()%>
				</p>
<%-- 				<%=food.getFoodsession()%>
 --%>				
 <input type="hidden" value="<%=food.getFoodsession()%>"
					name="foodSession">


				<%
				UserDetails userId = (UserDetails) session.getAttribute("userId");
				%>
				<div class="quantity-selector">
					<input type="hidden" name="userId" value="<%=userId.getUserId()%>">

					<input type="hidden" name="foodId" value="<%=food.getFoodId()%>">
					<input type="number"  class="view"id="quantity_<%=food.getFoodId()%>"
						name="quantity" min="1" value="1">
					<button type="submit" name="action" value="addToCart">AddtoCart</button>
					<input type="hidden" name="foodId" value="<%=food.getFoodId()%>">
					<input type="hidden" name="base64Image" value="<%=base64Image%>">
					<input type="hidden" name="price" value="<%=food.getFoodPrice()%>">
					<input type="hidden" id="quantity_<%=food.getFoodId()%>"
						name="quantity_<%=food.getFoodId()%>" value="">
		</form>



	</div>
	<%-- 			<form action="" method="post">
				<input type="hidden" name="foodId" value="<%=food.getFoodId()%>">
				<input type="hidden" id="quantity_input_<%=food.getFoodId()%>"
					name="quantity_" value="0"> <input type="submit"
					value="Add to Cart">
			</form>
 --%>



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
