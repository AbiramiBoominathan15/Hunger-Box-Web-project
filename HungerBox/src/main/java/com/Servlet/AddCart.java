package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.HungerImplements;
import com.model.CartItem;
import com.model.UserDetails;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("hi");
		HttpSession session = request.getSession();

		UserDetails userId = (UserDetails) session.getAttribute("userId");
		System.out.println("user  :" + userId.getUserId());
		int foodId = Integer.parseInt(request.getParameter("foodId"));
		System.out.println(foodId);

		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println(price);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity);

		
		
		
		
		
		
		
		
		
		double totalPrice = price * quantity;
		System.out.println(totalPrice);
		CartItem cartItem = new CartItem();
		cartItem.setUserId(userId.getUserId());
		cartItem.setFoodId(foodId);
		cartItem.setQuantity(quantity);
		cartItem.setTotalPrice(totalPrice);

		// CartItem cartItem = new CartItem(userId, foodId, quantity, totalPrice);

		// cartItem.setFoodId(request.getParameter("foodId"));
		try {
			HungerImplements.addCartItem(cartItem);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}