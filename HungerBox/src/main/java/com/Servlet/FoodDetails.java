package com.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.HungerImplements;
import com.model.Food;
import com.model.Hotel;
import com.model.UserDetails;

/**
 * Servlet implementation class FoodDetails
 */
@WebServlet("/FoodDetails")
@MultipartConfig
public class FoodDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Hotel> list = new ArrayList<Hotel>();
	Food food = new Food();
	Hotel hotel= new Hotel();

	HungerImplements implement = new HungerImplements();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodDetails() {
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
		// HttpSession session = request.getSession(false);

		// String hotel = (String) session.getAttribute("hotelId");
		// if(hotel != null) {
		// int hotelId = implement.HotelId();
		// Move the rest of your code that relies on hotel inside this block
		// This line might not be necessary, check if it's needed
		// System.out.println(hotelId);
		// } else {
		// Handle the case when hotelId is not found in the session
		// }

		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		String hotelName=request.getParameter("hotelname");
		String foodName = request.getParameter("foodName");
		String foodCategories = request.getParameter("foodCategory");
		int foodQuantity = Integer.parseInt(request.getParameter("foodQuantity"));
		int foodPrice = Integer.parseInt(request.getParameter("foodPrice"));
		String foodSession= request.getParameter("foodSession");
		System.out.println(foodSession);
		// InputStream foodImage = request.getParameter("mailId");
		Part filePart = request.getPart("image");
		InputStream fileContent = filePart.getInputStream();
		byte[] images = null;
		if (fileContent != null) {
			images = fileContent.readAllBytes();
		}
		
		
		
		
		
		
		
		
		
		food.setHotelId(hotelId);
		food.setHotelName(hotelName);
		food.setFoodName(request.getParameter("foodName"));
		food.setFoodCategories(request.getParameter("foodCategory"));
		food.setFoodPrice(foodPrice);
		food.setFoodQuantity(foodQuantity);
		food.setFoodsession(foodSession);
		food.setFoodImage(images);

		try {
			implement.foodDetails(food);
			System.out.println(food.foodId);
			HttpSession session = request.getSession();
			session.setAttribute("foodId", food.foodId);


//			List<UserDetails> list = implement.read();
//			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
