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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<UserDetails> list = new ArrayList<UserDetails>();
	UserDetails user = new UserDetails();
	HungerImplements implement = new HungerImplements();
	List<Hotel> list1 = new ArrayList<Hotel>();
	Hotel hotel = new Hotel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
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
		String hotelName = request.getParameter("name");
		String hotelLocation = request.getParameter("location");
		String hotelPhoneNumber = request.getParameter("phonenumber");

		hotel.setHotelName(request.getParameter("name"));
		hotel.setHotelLocation(request.getParameter("location"));
		hotel.setHotelPhoneNumber(request.getParameter("phonenumber"));
		try {
			HungerImplements.hotelDetails(hotel);
			List<Hotel> list1 = implement.read1();
			request.setAttribute("list", list1);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Hotel.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hi");
//	    String adminname = request.getParameter("adminname");
//	    String adminpassword = request.getParameter("adminpassword");
//	    try {
//	        implement.adminLogin(adminname,adminpassword);
//
//	}catch (SQLException | ClassNotFoundException e) {
//        e.printStackTrace();
//    }
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		String mailId = request.getParameter("mailId");

		user.setName(request.getParameter("name"));
		user.setPhoneNumber(request.getParameter("phonenumber"));
		user.setPassword(request.getParameter("password"));
		user.setCity(request.getParameter("city"));
		user.setMailId(request.getParameter("mailId"));

		try {
			System.out.println("phonenumber:" + phoneNumber);
			implement.userlogin(user);
			List<UserDetails> list = implement.read();
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("hunger.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

//		String name1 = request.getParameter("username");
//		String password1 = request.getParameter("password");
//		String phonenumber= request.getParameter("phonenumber");
//		
//		String adminName = "abirami@13";
//		String adminPassword = "abirami#23";
//		String adminphonenumber="9092685133";		
//		if (name1.equals(adminName) && password1.equals(adminPassword)&& phonenumber.equals(adminphonenumber)) {
//			response.sendRedirect("Hotel1.html");
//		} else {
//			response.sendRedirect("AdminLogin.html");
//		}

	}

//		String action = request.getParameter("action");
//		System.out.println(action);

//		switch (action) {
//		case "register":
//
//			try {
//
//				System.out.println("method calling");
//				if (implement.userlogin(user)) {
//	
//	System.out.println("1");
//					HttpSession session = request.getSession();
//					session.setAttribute("name", name);
//					session.setAttribute("phonenumber", phoneNumber);
//					session.setAttribute("password", password);
//					session.setAttribute("city", city);
//					session.setAttribute("mailId", mailId);
//////					listUser(request, response);
////					
//					List<UserDetails> list = implement.read();
//					request.setAttribute("list", list);
//
//					RequestDispatcher dispatcher = request.getRequestDispatcher("hunger.jsp");
//					dispatcher.forward(request, response);

//					response.sendRedirect("Index.html");
//
//				}
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			break;
//
//		case "login":
//
////			try {
////				if (HungerImplements.userlogin(user)) {
////					response.sendRedirect("LoginPage.html");
////
////				}
////			} catch (ClassNotFoundException | SQLException e) {
////				e.printStackTrace();
////				response.sendRedirect("hunger.jsp");
////			}
////			break;
//
//		}
//	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
