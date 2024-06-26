<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.*"%>
<%@ page import="com.model.Food"%>
<%@ page import="com.model.Hotel"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Details</title>
<style>
.btn-submit {
	background-color: #ba4357;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
	margin-left: 50%;
}

.btn-submit:hover {
	background-color: rgb(147, 24, 44);
}

.form-group #foodName {
	margin-left: 0%;
}

.form-group #foodPrice {
	margin-left: 0%;
}

.form-group #foodDescription {
	width: 43%;
}

.form-group #foodDescription {
	margin-left: 0%;
}

.form-group label[for="foodimage"] {
	display: inline-block;
	width: 100px;
	vertical-align: top;
}

.form-group input[type="text"], .form-group input[type="number"],
	.form-group select, .form-group textarea, .form-group input[type="file"]
	{
	width: calc(65% - 244px);
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box;
}

.form-group select {
	margin-right: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.form-container {
	background-color: lightgreen;
	width: 90%;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-top: 50px;
	margin-left: 50px;
}

.form-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<%
	int hotelId = (int) session.getAttribute("hotelId");
	%>
	<div class="form-container">
		<h2>Food Details</h2>
		<form action="FoodDetails" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="hotelid">Hotel Id:</label> <input type="text"
					id="hotelid" name="hotelid" value="<%=hotelId%>" readonly>
			</div>
			<div class="form-group">
				<label for="hotelName">HotelName:</label> <input type="text"
					id="hotelName" name="hotelname" required>
			</div>
			<div class="form-group">
				<label for="foodCategory">Food Category:</label> <select
					id="foodCategory" name="foodCategory" required>
					<option value="">Select Category</option>
					<option value="Veg">Veg</option>
					<option value="Non-veg">Non-Veg</option>
				</select>
			</div>
			<div class="form-group">
				<label for="foodName " id="foodName">Food Name:</label> <input
					type="text" id="foodName" name="foodName" required>
			</div>
			<div class="form-group">
				<label for="foodSession">MealSession:</label> <select
					id="foodSession" name="foodSession" required>
					<option value="">Select Category</option>
					<option value="Breakfast">Breakfast</option>
					<option value="Lunch">Lunch</option>
					<option value="Dinner">Dinner</option>
				</select>
			</div>
			<div class="form-group">
				<label for="foodPrice" id="foodPrice">Food Price:</label> <input
					type="number" id="foodPrice" name="foodPrice" min="0" step="0.01"
					required>
			</div>
			<div class="form-group">
				<label for="foodQuantity" id="foodQuantity">Food Quantity:</label> <input
					type="number" id="foodQuantity" name="foodQuantity" min="0"
					step="0.01" required>
			</div>
			<div class="form-group">
				<label for="foodimage" id="foodimage">Food Image:</label> <input
					type="file" name="image" accept="image/*">
			</div>
			<div class="form-group">
				<label for="foodDescription" id="foodDescription">Food
					Description:</label>
				<textarea id="foodDescription" name="foodDescription" rows="4"
					placeholder="Enter food description"></textarea>
			</div>
			<button type="submit" class="btn-submit">Submit</button>
		</form>
	</div>
</body>
</html>
