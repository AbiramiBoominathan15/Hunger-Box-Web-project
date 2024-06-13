package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	List<CartItem> list = new ArrayList<CartItem>();
	CartItem cartItem = new CartItem();
	HungerImplements implement = new HungerImplements();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCart() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); UserDetails userId =
		 * (UserDetails) session.getAttribute("userId");
		 * 
		 * List<CartItem> list = null; try { list = implement.readCart(userId); } catch
		 * (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
		 * 
		 * // Calculate total cart price double totalCartPrice =
		 * implement.getTotalCartPrice(list);
		 * 
		 * request.setAttribute("list", list); request.setAttribute("totalCartPrice",
		 * totalCartPrice);
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
		 * dispatcher.forward(request, response); }
		 */

		System.out.println("Abiiii");
		HttpSession session = request.getSession();

		UserDetails userId = (UserDetails) session.getAttribute("userId");

		List<CartItem> list = null;
		try {
			list = implement.readCart(userId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
		dispatcher.forward(request, response);

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
		String foodsession = request.getParameter("foodSession");
		System.out.println(foodsession);
		double totalPrice = price * quantity;
		System.out.println(totalPrice);

		// CartItem cartItem = new CartItem();
		cartItem.setUserId(userId.getUserId());
		cartItem.setFoodId(foodId);
		cartItem.setQuantity(quantity);
		cartItem.setFoodsession(foodsession);
		cartItem.setTotalPrice(totalPrice);

		// CartItem cartItem = new CartItem(userId, foodId, quantity, totalPrice);

		// cartItem.setFoodId(request.getParameter("foodId"));
		try {
			String choice = request.getParameter("action");
			System.out.println("Choice : " + choice);
			if (choice.equals("addToCart")) {
				HungerImplements.addCartItem(cartItem);
				System.out.println("hello in");
				response.sendRedirect("MenuDisplay.jsp");

			} else if (choice.equals("viewCart")) {
				List<CartItem> list = implement.readCart(userId);
				response.sendRedirect("Menu.jsp");
				request.setAttribute("list", list);

				// RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
				// dispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}