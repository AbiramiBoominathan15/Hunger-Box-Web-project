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

import com.model.Food;
import com.model.Hotel;

/**
 * Servlet implementation class UserMenuDisplay
 */
@WebServlet("/UserMenuDisplay")
public class UserMenuDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Food> foodlist = new ArrayList<Food>();
	Food food = new Food();
	HungerImplements implement = new HungerImplements();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMenuDisplay() {
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
		 try {
	            // Retrieve book details from the database
	            List<Food> foodlist = implement.read2();
	            
	            // Set the attribute for the JSP page
	            request.setAttribute("foodlist", foodlist);

	            // Forward to JSP page
	            RequestDispatcher dispatcher = request.getRequestDispatcher("MenuDisplay.jsp");
	            dispatcher.forward(request, response);
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            // Handle exceptions
	        }
	    }
}

//	    private List<Book> retrieveBookDetails() throws SQLException, ClassNotFoundException {
//	        // Use LibraryImpl to retrieve book details from the database
//	        LibraryImpl libraryImpl = new LibraryImpl();
//	        return libraryImpl.getAllBooks(); // Assuming this method retrieves all books from the database
//	    }
//	}
//	