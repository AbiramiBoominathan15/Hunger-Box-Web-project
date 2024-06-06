package com.DAO;
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
import javax.servlet.http.Part;

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
	HungerImplements implement = new HungerImplements();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		String foodName = request.getParameter("foodName");
		String foodCategories = request.getParameter("foodCategory");
		int foodPrice = Integer.parseInt(request.getParameter("foodPrice"));
		//InputStream foodImage = request.getParameter("mailId");
		Part filePart = request.getPart("image");
		InputStream fileContent = filePart.getInputStream();
		byte[] images =null;
        if(fileContent !=null) {
            images = fileContent.readAllBytes();
        }

		
		food.setHotelId(hotelId);
		food.setFoodName(request.getParameter("foodName"));
		food.setFoodCategories(request.getParameter("foodCategory"));
		food.setFoodPrice(foodPrice);
		food.setFoodImage(images);

		try {
			implement.foodDetails(food);
//			List<UserDetails> list = implement.read();
//			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
