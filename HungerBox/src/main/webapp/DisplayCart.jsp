<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Summary</title>
</head>
<body>
<h1>Order Summary</h1>

<div>
    <%
    String foodId = request.getParameter("foodId");
    System.out.println("from display :"+foodId);

    String quantityParam = request.getParameter("quantity_" + foodId);
    System.out.println("from display :"+quantityParam);
    
    System.out.println("foodID :"+foodId+ " quantity :"+quantityParam);
      //  String foodId1 = request.getParameter("foodId");
        String quantityParam1= request.getParameter("quantity");
        String priceParam = request.getParameter("price");
        String base64Image = request.getParameter("base64Image");
        
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;

        if (quantityParam != null && !quantityParam.isEmpty()) {
        	
            quantity = Integer.parseInt(quantityParam);
        }

        if (priceParam != null && !priceParam.isEmpty()) {
            price = Double.parseDouble(priceParam);
        }

        if (quantity > 0 && price > 0) {
            totalPrice = quantity * price;
        }
    %>

    <div>
        <h2>Item Details</h2>
        <p>Food ID: <%= foodId %></p>
        <p>Quantity: <%= quantity %></p>
        <p>Price: <%= price %></p>
    </div>

    <div>
        <h2>Food Image</h2>
        <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Food Image" style="width: 200px; height: 200px;">
    </div>

    <div>
        <h2>Total Price</h2>
        <p><%= quantity %> item(s) at <%= price %> each = <%= totalPrice %></p>
    </div>
</div>

</body>
</html>
