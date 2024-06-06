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

import com.model.Hotel;

/**
 * Servlet implementation class AdminUpdateServlet
 */
@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Hotel> list = new ArrayList<Hotel>();
	Hotel hotel = new Hotel();
	HungerImplements implement = new HungerImplements();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServlet() {
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
		String name = request.getParameter("name");
		System.out.println(name);
		hotel.setHotelName(name);
		String location = request.getParameter("location");
		System.out.println(location);
		hotel.setHotelLocation(location);

		String phonenumber = request.getParameter("phonenumber");
		System.out.println(phonenumber);
		hotel.setHotelPhoneNumber(phonenumber);
        
        try {
        	implement.updateAdmin(hotel);
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        try {
            list=implement.read1();    
            
            
             
        }
        catch (ClassNotFoundException | SQLException e) {
              
               e.printStackTrace();
           }
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Hotel.jsp");
        dispatcher.forward(request, response);
    }


	}


