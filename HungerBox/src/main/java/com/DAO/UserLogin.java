package com.DAO;

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

import com.model.Hotel;
import com.model.UserDetails;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<UserDetails> list = new ArrayList<UserDetails>();
	UserDetails user = new UserDetails();
	HungerImplements implement = new HungerImplements();
	List<Hotel> list1 = new ArrayList<Hotel>();
	Hotel hotel = new Hotel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
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
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		String mailId = request.getParameter("mailid");
		user.setName(request.getParameter("name"));
		user.setPhoneNumber(request.getParameter("phonenumber"));
		user.setPassword(request.getParameter("password"));

		if (name.equals("abirami213") && password.equals("abirami1123")) {
			System.out.println(name);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Hotel1.html");
			dispatcher.forward(request, response);

		} else if (name.equals("hotelsuki") && password.equals("hotelsuki12")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Hote1.html");
			dispatcher.forward(request, response);

		}

		else {
			try {
				if (implement.login(user)) {
					
					
					UserDetails userId = implement.getUserId(user);
					System.out.println(userId);
					HttpSession session = request.getSession();
					System.out.println(userId);
					session.setAttribute("userId", userId);
					response.sendRedirect("MenuDisplay.jsp");
				} else {
					response.sendRedirect("LoginPage.html");
				}
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
