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
import com.model.CartItem;
import com.model.UserDetails;

/**
 * Servlet implementation class CartQuantityUpdate
 */
@WebServlet("/CartQuantityUpdate")
public class CartQuantityUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<CartItem> list = new ArrayList<CartItem>();
	CartItem cartItem = new CartItem();
	HungerImplements implement = new HungerImplements();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartQuantityUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession();

	    	UserDetails userId = (UserDetails) session.getAttribute("userId");
	        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
	        int foodId = Integer.parseInt(request.getParameter("foodId"));
	        

	        CartItem cartItem = new CartItem();
	        cartItem.setUserId(userId.getUserId());
	        cartItem.setFoodId(foodId);

	        try {
	            HungerImplements hungerImplements = new HungerImplements();
	            
	           double foodPrice=hungerImplements.getFoodPrice(foodId);
	            double total=newQuantity*foodPrice;
	            hungerImplements.updateCartItemQuantity(cartItem, foodId, newQuantity,total);
	            List<CartItem> list = null;
	    		try {
	    			list = implement.readCart( userId);
	    		} catch (ClassNotFoundException | SQLException e) {
	    			e.printStackTrace();
	    		}
	    		request.setAttribute("list", list);

	    		RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
	    		dispatcher.forward(request, response);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	      
	            
	            
	            response.sendRedirect("error.jsp");
	        }
	    }
}


