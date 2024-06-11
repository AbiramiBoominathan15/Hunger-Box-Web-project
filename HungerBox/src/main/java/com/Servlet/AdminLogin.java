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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Hotel> list = new ArrayList<Hotel>();
	Hotel hotel = new Hotel();
	HungerImplements implement = new HungerImplements();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unused")
		String hotelName = request.getParameter("name");
		@SuppressWarnings("unused")
		String hotelLocation = request.getParameter("location");
		@SuppressWarnings("unused")
		String hotelPhoneNumber = request.getParameter("phonenumber");

		
		
		
		
		
		
		hotel.setHotelName(request.getParameter("name"));
		hotel.setHotelLocation(request.getParameter("location"));
		hotel.setHotelPhoneNumber(request.getParameter("phonenumber"));
		try {
			if(HungerImplements.hotelDetails(hotel)) {
				
			}
			
			List<Hotel> list = implement.read1();
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Hotel.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String mailId = request.getParameter("mailId");
		String adminName = "abirami@13";
		String adminPassword = "abirami#23";
		String adminphonenumber = "9092685133";
		String MailId = "abiramiboominathan@gmail.com";
		if (name.equals(adminName) && password.equals(adminPassword) && phonenumber.equals(adminphonenumber)
				&& mailId.equals(MailId)) {
			response.sendRedirect("Hotel1.html");
		} else {
			response.sendRedirect("AdminLogin.html");
		}

	}

}
