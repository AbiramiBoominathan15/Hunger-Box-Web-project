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

import com.DAO.HungerImplements;
import com.model.Hotel;

/**
 * Servlet implementation class AdminApproved
 */
@WebServlet("/AdminApproved")
public class AdminApproved extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Hotel hotel = new Hotel();
	HungerImplements implement = new HungerImplements();
	List<Hotel> list1 = new ArrayList<Hotel>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminApproved() {
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
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * int hotelId = Integer.parseInt(request.getParameter("hotelId")); String
	 * hotelStatus=request.getParameter("approved");
	 * System.out.println("status::"+hotelStatus); try { hotel.setHotelId(hotelId);
	 * hotel.setHotelStatus(hotelStatus); implement.updateStatus(hotel); list1 =
	 * implement.read1();
	 * 
	 * 
	 * } catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
	 * request.setAttribute("list", list1); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("hotel.jsp"); dispatcher.forward(request,
	 * response); }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		String hotelStatus = request.getParameter("approved");

		try {
			hotel.setHotelId(hotelId);
		
			
			System.out.println("id" + hotelId);
			hotel.setHotelStatus(hotelStatus);
			System.out.println("status"+hotelStatus);
			implement.updateStatus(hotel);
			list1 = implement.read1();

			request.setAttribute("list", list1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("hotel.jsp");
		
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
