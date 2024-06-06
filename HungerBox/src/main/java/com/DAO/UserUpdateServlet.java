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

import com.model.UserDetails;



/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDetails user = new UserDetails();
HungerImplements implement = new HungerImplements();
	List<UserDetails> list = new ArrayList<>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
		doGet(request, response);
		String name = request.getParameter("name");
		user.setName(name);
		String phoneNumber = request.getParameter("phonenumber");
		System.out.println(phoneNumber);
		user.setPhoneNumber(phoneNumber);

		String password = request.getParameter("password");
		user.setPassword(password);
		String city = request.getParameter("city");
		System.out.println(city);
		user.setCity(city);

		String MailId = request.getParameter("mailId");
		user.setMailId(MailId);
        
        try {
        	implement.update(user);
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        try {
            list=implement.read();    
            
            
             
        }
        catch (ClassNotFoundException | SQLException e) {
              
               e.printStackTrace();
           }
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hunger.jsp");
        dispatcher.forward(request, response);
    }

	}

