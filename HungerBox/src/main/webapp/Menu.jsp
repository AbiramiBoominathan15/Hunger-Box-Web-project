<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Details</title>
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

.pay-now-button {
    display: block;
    margin: 110px 545px;
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}

.pay-now-button:hover {
    background-color: #45a049;
}
</style>
</head>
<body>
    <h1>Cart Details</h1>
    <table border="1">
        <tr>
            <th>UserId</th>
            <th>FoodId</th>
            <th>Quantity</th>
            <th>TotalPrice</th>
            <th>MealTime</th>
            <th colspan="2">Actions</th>
        </tr>
        <%
        List<CartItem> list1 = (ArrayList<CartItem>) request.getAttribute("list");
        double overallTotalPrice = 0;
        if (list1 != null) {
            for (CartItem cartItem : list1) {
                overallTotalPrice += cartItem.getTotalPrice();
                System.out.println("----" + cartItem.getFoodsession());
        %>
        <tr>
            <td><%=cartItem.getUserId()%></td>
            <td><%=cartItem.getFoodId()%></td>
            <td><%=cartItem.getQuantity()%></td>
            <td><%=cartItem.getTotalPrice()%></td>
            <td><%=cartItem.getFoodsession()%></td>
            
             <td>
                <form action="CartQuantityUpdate" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="foodId" value="<%=cartItem.getFoodId()%>">
                    <input type="number" name="quantity" value="<%=cartItem.getQuantity()%>">
                    <button type="submit" title="update">Update</button>
                </form>
            </td>
             <td>
                <form action="UserCartDelete" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="delete" value="<%=cartItem.getFoodId()%>">
                    <button type="submit" title="delete">Remove</button>
                </form>
            </td>
        </tr>
        <%
            }
        }
        %>
        <tr>
            <td colspan="4"></td>
            <td colspan="2"><strong>Overall Total Price:</strong></td>
            <td><%=overallTotalPrice%></td>
        </tr>
    </table>
    <form action="StockUpdated" method="post">
        <input type="hidden" name="overallTotalPrice" value="<%=overallTotalPrice%>">
        <a href="paymentPage.jsp?price=<%=overallTotalPrice%> "class="pay-now-button">Pay Now</a>
    </form>
</body>
</html>
