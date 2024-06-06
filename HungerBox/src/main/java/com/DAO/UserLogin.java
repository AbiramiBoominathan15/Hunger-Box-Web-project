package com.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		String mailId=request.getParameter("mailid");
		user.setName(request.getParameter("name"));
		user.setPhoneNumber(request.getParameter("phonenumber"));
		user.setPassword(request.getParameter("password"));
		

		
		String adminName = "abirami@13";
		String adminPassword = "abirami#23";
		String adminphonenumber="9092685133";
		String MailId="abiramiboominathan15@gmail.com";
		
		if (name.equals(adminName) && password.equals(adminPassword)&& phoneNumber.equals(adminphonenumber)&& mailId.equals(MailId)) {
			response.sendRedirect("Hotel1.html");
		} else {
			try
			 {
				 if(implement.userlogin(user)) {
						response.sendRedirect("MenuDisplay.jsp");
				 }
				 else {
					 response.sendRedirect("LoginPage.html");
				 }

				}	catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					response.sendRedirect("LoginPage.html");
				

					
				}
			
		}
}
}
