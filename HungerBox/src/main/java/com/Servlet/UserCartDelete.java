package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.HungerImplements;
import com.model.CartItem;
import com.model.Food;
import com.model.UserDetails;

/**
 * Servlet implementation class UserCartDelete
 */
@WebServlet("/UserCartDelete")
public class UserCartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<CartItem> list = new ArrayList<CartItem>();
	CartItem cartItem = new CartItem();
	HungerImplements implement = new HungerImplements();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCartDelete() {
		
		
		
		
		
		
		
		
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int foodId = Integer.parseInt(request.getParameter("delete"));
		cartItem.setFoodId(foodId);
		try {

			implement.deleteCart(foodId);
			HttpSession session = request.getSession();
			UserDetails userId = (UserDetails) session.getAttribute("userId");
			List<CartItem> cartItemList = implement.readCart(userId);

			request.setAttribute("list", cartItemList);
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
