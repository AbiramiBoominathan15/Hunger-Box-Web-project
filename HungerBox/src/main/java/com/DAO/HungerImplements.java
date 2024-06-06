package com.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Food;
import com.model.Hotel;
import com.model.UserDetails;
import com.util.HungerConnection;
public class HungerImplements implements HungerDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db_17";
    public static final String DB_USER = "abiramiHunger@15";
    public static final String DB_PASSWORD = "abiHUNGER#2";

//	public void adminLogin(String adminname, String adminpassword) throws ClassNotFoundException, SQLException {
//		Connection connection = HungerConnection.getConnection();
//		try {
//			String query = "SELECT * FROM admin WHERE adminname = ? AND adminpassword = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, adminname);
//			preparedStatement.setString(2, adminpassword);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				System.out.println("Login successful!");
//			} else {
//				System.out.println("Name or Password incorrect. Access denied.\n" + "Please enter valid details");
//				adminLogin(adminname, adminpassword);
//			}
//			resultSet.close();
//			preparedStatement.close();
//		} catch (SQLException e) {
//			System.out.println("Please enter valid details");
//			e.printStackTrace();
//		}
//	}
//
//    public static boolean userExists(UserDetails user) throws ClassNotFoundException, SQLException {
//        Connection connection = HungerConnection.getConnection();
//        String query = "SELECT * FROM Userdetails WHERE mailId = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1, user.getMailId());
//        ResultSet resultSet = preparedStatement.executeQuery();
//        boolean exists = resultSet.next();
//        resultSet.close();
//        preparedStatement.close();
//        connection.close();
//        return false;
//    }
	public static boolean loginUser(UserDetails user) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
		String query = "SELECT * FROM User_Details WHERE mail_id = ? AND password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getMailId());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		boolean loginSuccess = resultSet.next();
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return loginSuccess;
	}
//	public static boolean userExists1(UserDetails user) throws ClassNotFoundException, SQLException {
//        Connection connection = HungerConnection.getConnection();
//        String query = "SELECT * FROM Userdetails WHERE mailId = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1, user.getMailId());
//        ResultSet resultSet = preparedStatement.executeQuery();
//        boolean exists = resultSet.next();
//        resultSet.close();
//        preparedStatement.close();
//        connection.close();
//        return false;
//	}
//}

	public boolean userlogin(UserDetails user) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
        String query = "SELECT * FROM User_Details WHERE name=? AND phone_number=? AND password=? AND mail_id=?";

//		String query = "SELECT * FROM User_Details WHERE mail_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getMailId());
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("User already exists");

		if (resultSet.next()) {
			System.out.println("User not exists");
		} else {
			String save = "INSERT INTO User_Details (name, phone_number, city, password, mail_id) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(save);
			System.out.println(user.getName() + "" + user.getPhoneNumber() + "" + user.getCity() + ""
					+ user.getPassword() + "" + user.getMailId());
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getCity());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getMailId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Registration successful");
				return true;
			} else {
				System.out.println("Registration failed");
			}

		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return false;
	}

	public static String loginCheck(String name) throws ClassNotFoundException, SQLException {
		String password = null;
		Connection connection = HungerConnection.getConnection();
		String query = "SELECT password from User_Details WHERE name= ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,name);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			password = resultSet.getString(1);
		}
		System.out.println(resultSet + "retrieved");
		return password;

	}

	@Override
	public void adminLogin(String name, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	public List<UserDetails> read() throws ClassNotFoundException, SQLException {
		List<UserDetails> list = new ArrayList<>();
		Connection connection = HungerConnection.getConnection();
		String update = "select * from User_Details";
		PreparedStatement ps = connection.prepareStatement(update);
		try {
//			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phone_number");
				String password = rs.getString("password");
				String city = rs.getString("city");
				String mailId = rs.getString("mail_id");
				list.add(new UserDetails(name, phoneNumber, password, city,mailId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Read end
	public void update(UserDetails user) throws ClassNotFoundException, SQLException {
		String save = " UPDATE User_Details SET phone_number=?, password = ?, city=? ,mail_id=? WHERE name = ?";
		try (Connection connection = HungerConnection.getConnection();
				PreparedStatement p = connection.prepareStatement(save);) {
			System.out.println("city in db"+user.getCity());
			System.out.println("city in db"+user.getMailId());
			p.setString(1, user.getPhoneNumber());
			p.setString(2, user.getPassword());
			p.setString(3, user.getCity());
			p.setString(4, user.getMailId());
			p.setString(5, user.getName());
			int rows = p.executeUpdate();
			System.out.println(rows + "rows updated");
			p.close();
			connection.close();
		}
	}
//	public List<EmployeeRegistrationForm> search(String Name) throws ClassNotFoundException, SQLException {
//		List<EmployeeRegistrationForm> users = new ArrayList<>();
//		System.out.println(Name);
//		Connection connection = EmployeeRegistrationConnection.getConnection();
//		String updateEmployeeData = "select * from EmployeeDetails where Name=?";
//		PreparedStatement ps = connection.prepareStatement(updateEmployeeData);
//		ps.setString(1, Name);
//		try {
//			System.out.println(ps);
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				String name = rs.getString("Name");
//				String Password = rs.getString("Password");
//				String Mail_Id = rs.getString("Mail_Id");
//				String PhoneNumber = rs.getString("PhoneNumber");
//				users.add(new EmployeeRegistrationForm(name, Password, Mail_Id, PhoneNumber));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}
//

	public boolean delete(String name) throws ClassNotFoundException, SQLException {
		boolean rowDeleted;
		String deleteEmployeeData = "delete from User_Details where name=?";
		try (Connection connection = HungerConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(deleteEmployeeData);) {
			ps.setString(1, name);
			rowDeleted = ps.executeUpdate() > 0;
			ps.close();
			connection.close();
		}
		return rowDeleted;
	}
    public static boolean authenticate(String name, String password) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            
            String sql = "SELECT * FROM User_Details WHERE name = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public static boolean hotelDetails(Hotel hotel) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
			String save = "INSERT INTO Hotels_Details (hotel_name,hotel_location,hotel_phonenumber) VALUES ( ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(save);
			System.out.println( hotel.getHotelName()+ "" + hotel.getHotelLocation() + ""
					+ hotel.getHotelPhoneNumber());
			preparedStatement.setString(1, hotel.getHotelName());
			preparedStatement.setString(2, hotel.getHotelLocation());
			preparedStatement.setString(3, hotel.getHotelPhoneNumber());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Registration successful");
			} else {
				System.out.println("Registration failed");
			}
		return false;
	}

	public List<Hotel> read1() throws ClassNotFoundException, SQLException {
		List<Hotel> list= new ArrayList<>();
		Connection connection = HungerConnection.getConnection();
		String update = "select * from Hotels_Details";
		PreparedStatement ps = connection.prepareStatement(update);
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String hotelName = rs.getString("hotel_name");
				String hotelLocation = rs.getString("hotel_location");
				String phoneNumber= rs.getString("hotel_phonenumber");
				list.add(new Hotel(hotelName, hotelLocation, phoneNumber));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateAdmin(Hotel hotel) throws ClassNotFoundException, SQLException {
		String save = " UPDATE Hotels_Details SET hotel_location=?, hotel_phonenumber = ? WHERE hotel_name = ?";
		try (Connection connection = HungerConnection.getConnection();
				PreparedStatement p = connection.prepareStatement(save);) {
			p.setString(1, hotel.getHotelLocation());
			p.setString(2, hotel.getHotelPhoneNumber());
			p.setString(3, hotel.getHotelName());
			int rows = p.executeUpdate();
			System.out.println(rows + "rows updated");
			p.close();
			connection.close();
		}
	}
	public boolean deleteHotel(String name) throws ClassNotFoundException, SQLException {
		boolean rowDeleted;
		String deleteEmployeeData = "delete from Hotels_Details where hotel_name=?";
		try (Connection connection = HungerConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(deleteEmployeeData);) {
			ps.setString(1, name);
			rowDeleted = ps.executeUpdate() > 0;
			ps.close();
			connection.close();
		}
		return rowDeleted;
	}
	public static boolean foodDetails(Food food) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
			String save = "INSERT INTO Food_Details (hotel_id,food_image,food_name,food_price,food_catagories) VALUES ( ?, ?, ?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(save);
			System.out.println(food.getHotelId()+ "" + food.getFoodImage() + ""
					+ food.getFoodName()+""+food.getFoodPrice()+ "" + food.getFoodCategories());
							
			preparedStatement.setInt(1, food.getHotelId());
			preparedStatement.setBytes(2,food.getFoodImage());
			preparedStatement.setString(3,food.getFoodName());
			preparedStatement.setInt(4,food.getFoodPrice());
			preparedStatement.setString(5,food.getFoodCategories());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Registration successful");
			} else {
				System.out.println("Registration failed");
			}
		return false;
	}
	
	public static List<Food> read2() throws ClassNotFoundException, SQLException {
		List<Food> foodlist= new ArrayList<>();
		Connection connection = HungerConnection.getConnection();
		String update = "select * from Food_Details";
		PreparedStatement ps = connection.prepareStatement(update);
		ResultSet rs = ps.executeQuery();

		try {
			//ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				food.setHotelId(rs.getInt("hotel_id"));
				food.setFoodImage(rs.getBytes("food_image"));
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getInt("food_price"));
				food.setFoodCategories(rs.getString("food_catagories"));
				foodlist.add(food);
			}
		}
    finally {
        // Close ResultSet, PreparedStatement, and Connection
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
        	ps.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    return foodlist;
}


}