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
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		@SuppressWarnings("unused")
		String phoneNumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		String mailId = request.getParameter("Mailid");
		user.setName(request.getParameter("name"));
		user.setPhoneNumber(request.getParameter("phonenumber"));
		user.setMailId(request.getParameter("Mailid"));
		user.setPassword(request.getParameter("password"));

		if (password.equals("abirami1123") && mailId.equals("abiramiboominathan@gmail.com")) {
			System.out.println(name);

			RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
			dispatcher.forward(request, response);

		} else {
			try {
				if (implement.businesslogin(mailId, password)) {
					try {

						Hotel hotel = implement.hotelLogin(mailId, password);
						if (hotel != null && hotel.getHotelStatus().equalsIgnoreCase("yes")) {
							HttpSession session = request.getSession();
							session.setAttribute("hotel", hotel);
							response.sendRedirect("hotelmenu.jsp");
						} else {
							request.setAttribute("message", "Hotel login failed or not approved.");
							RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage.jsp");
							dispatcher.forward(request, response);
						}
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
						response.sendRedirect("loginPage.jsp");
					}

				} else {
					try {
						if (implement.login(user)) {
							UserDetails userId = implement.getUserId(user);

							HttpSession session = request.getSession();
							if (userId != null) {
								System.out.println(userId);

							}

							session.setAttribute("userId", userId);

							response.sendRedirect("menuDisplay.jsp");
						} else {
							response.sendRedirect("loginPage.jsp");
						}
					} catch (ClassNotFoundException | SQLException | IOException e) {

						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
}