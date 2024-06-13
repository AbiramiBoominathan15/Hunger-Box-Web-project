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
import com.model.Food;
import com.model.Hotel;
import com.model.UserDetails;

/**
 * Servlet implementation class UserMenuDisplay
 */
@WebServlet("/UserMenuDisplay")
public class UserMenuDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Food> foodlist = new ArrayList<Food>();
	Food food = new Food();
	HungerImplements implement = new HungerImplements();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserMenuDisplay() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			HttpSession session = request.getSession(false);
			@SuppressWarnings("unused")
			UserDetails user = (UserDetails) session.getAttribute("userId");

			@SuppressWarnings("static-access")
			List<Food> foodlist = implement.read2();

			request.setAttribute("foodlist", foodlist);

			RequestDispatcher dispatcher = request.getRequestDispatcher("MenuDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
	}
}
