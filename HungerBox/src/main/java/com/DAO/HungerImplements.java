package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CartItem;
import com.model.Food;
import com.model.Hotel;
import com.model.UserDetails;
import com.util.HungerConnection;

public class HungerImplements implements HungerDAO {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db_17";
	public static final String DB_USER = "abiramiHunger@15";
	public static final String DB_PASSWORD = "abiHUNGER#2";

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

	public boolean userlogin(UserDetails user) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
		System.out.println(user.getName() + "" + user.getPhoneNumber() + "" + user.getPassword() + "" + user.getCity()
				+ "" + user.getMailId());

		String query = "SELECT * FROM User_Details WHERE name=? AND phone_number=? AND password=? AND mail_id=?";

//		String query = "SELECT * FROM User_Details WHERE mail_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getPhoneNumber());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getMailId());

		ResultSet resultSet = preparedStatement.executeQuery();

		if (!resultSet.next()) {
			String save = "INSERT INTO User_Details (name, phone_number, password, city, mail_id) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(save);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getCity());
			preparedStatement.setString(5, user.getMailId());
			preparedStatement.execute();
			System.out.println("Registration successful");
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
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			password = resultSet.getString(1);
		}
		System.out.println(resultSet + "retrieved");
		return password;

	}

	public static boolean login(UserDetails user) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();

		String query = "SELECT name from User_Details WHERE mail_id= ? AND password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getMailId());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;

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
				list.add(new UserDetails(name, phoneNumber, password, city, mailId));
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
			System.out.println("city in db" + user.getCity());
			System.out.println("city in db" + user.getMailId());
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

	/*
	 * public boolean delete(String name) throws ClassNotFoundException,
	 * SQLException { boolean rowDeleted; String delete =
	 * "delete from User_Details where name=?"; try (Connection connection =
	 * HungerConnection.getConnection(); PreparedStatement ps =
	 * connection.prepareStatement(delete);) { ps.setString(1, name); rowDeleted =
	 * ps.executeUpdate() > 0; ps.close(); connection.close(); } return rowDeleted;
	 * }
	 */
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
		System.out.println(hotel.getHotelName() + "" + hotel.getHotelLocation() + "" + hotel.getHotelPhoneNumber());
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
		List<Hotel> list = new ArrayList<>();
		Connection connection = HungerConnection.getConnection();
		String update = "select * from Hotels_Details";
		PreparedStatement ps = connection.prepareStatement(update);
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String hotelName = rs.getString("hotel_name");
				String hotelLocation = rs.getString("hotel_location");
				String phoneNumber = rs.getString("hotel_phonenumber");
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
		String delete = "delete from Hotels_Details where hotel_name=?";
		try (Connection connection = HungerConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(delete);) {
			ps.setString(1, name);
			rowDeleted = ps.executeUpdate() > 0;
			ps.close();
			connection.close();
		}
		return rowDeleted;
	}

	public static boolean foodDetails(Food food) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
		String save = "INSERT INTO Food_Details (hotel_id,hotel_name,food_image,food_name,food_price,food_quantity,food_catagories,meal_time) VALUES ( ?, ?, ?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(save);
		System.out.println(food.getHotelId() + "" + food.getFoodImage() + "" + food.getFoodName() + ""
				+ food.getFoodPrice() + "" + food.getFoodCategories());

		preparedStatement.setInt(1, food.getHotelId());
		preparedStatement.setString(2, food.getHotelName());
		preparedStatement.setBytes(3, food.getFoodImage());
		preparedStatement.setString(4, food.getFoodName());
		preparedStatement.setInt(5, food.getFoodPrice());
		preparedStatement.setInt(6, food.getFoodQuantity());
		preparedStatement.setString(7, food.getFoodCategories());
		preparedStatement.setString(8, food.getFoodsession());

		int rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Registration successful");
		} else {
			System.out.println("Registration failed");
		}
		return false;
	}

	public static List<Food> read2() throws ClassNotFoundException, SQLException {
		int hour = java.time.LocalTime.now().getHour();

		String mealTime = "";
		if (hour >= 6 && hour < 12) {
			mealTime = "Breakfast";
		} else if (hour >= 12 && hour < 17) {
			mealTime = "Lunch";
		} else {
			mealTime = "Dinner";
		}

		List<Food> foodlist = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = HungerConnection.getConnection();
			String update = "select * from Food_Details where meal_time = ?";
			if (!mealTime.equalsIgnoreCase("Breakfast") && !mealTime.equalsIgnoreCase("Lunch") && hour >= 12) {
				update = "select * from Food_Details where meal_time in ( 'Dinner')";
				ps = connection.prepareStatement(update);
			} else {
				update = "select * from Food_Details where meal_time = ?";
				ps = connection.prepareStatement(update);
				ps.setString(1, mealTime);
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				Food food = new Food();
				food.setFoodId(rs.getInt("food_id"));
				food.setHotelId(rs.getInt("hotel_id"));
				food.setHotelName(rs.getString("hotel_name"));
				food.setFoodImage(rs.getBytes("food_image"));
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getInt("food_price"));
				food.setFoodCategories(rs.getString("food_catagories"));
				food.setFoodsession(rs.getString("meal_time"));

				if (mealTime.equals("Lunch") && hour >= 17) {
					food.setAvailability("Unavailable");
				} else if (mealTime.equals("Breakfast") && hour >= 12) {
					food.setAvailability("Unavailable");
				} else {
					food.setAvailability("Available");
				}

				foodlist.add(food);
			}
		} finally {
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

	public UserDetails getUserId(UserDetails user) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
		String query = "SELECT * FROM User_Details WHERE mail_id=?";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, user.getMailId());
		ResultSet rows = p.executeQuery();
		if (rows.next()) {
			user.setUserId(rows.getInt("user_id"));
			user.setName(rows.getString("name"));
			user.setPhoneNumber(rows.getString("phone_number"));
			user.setPassword(rows.getString("password"));
			user.setCity(rows.getString("city"));
			user.setMailId(rows.getString("mail_id"));
			return user;
		}
		return null;
	}

	public static boolean addCartItem(CartItem cartItem) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();

		String save = "INSERT INTO Cart_Items (user_id, food_id, quantity, totalprice,meal_time) VALUES (?, ?, ?, ?,?)";
		System.out.println("Parameters: user_id=" + cartItem.getUserId() + ", food_id=" + cartItem.getFoodId()
				+ ", quantity=" + cartItem.getQuantity() + ", totalprice=" + cartItem.getTotalPrice());

		PreparedStatement preparedStatement = connection.prepareStatement(save);
		preparedStatement.setInt(1, cartItem.getUserId());
		preparedStatement.setInt(2, cartItem.getFoodId());
		preparedStatement.setInt(3, cartItem.getQuantity());
		preparedStatement.setDouble(4, cartItem.getTotalPrice());
		preparedStatement.setString(5, cartItem.getFoodsession());

		int rowsAffected = preparedStatement.executeUpdate();

		if (rowsAffected > 0) {
			System.out.println("CartItem added successfully");
			return true;
		} else {
			System.out.println("Failed to add CartItem");
			return false;
		}
	}

	public List<CartItem> readCart(UserDetails userId2) throws ClassNotFoundException, SQLException {
		int hour = java.time.LocalTime.now().getHour();

		String mealTime = "";
		if (hour >= 6 && hour < 12) {
			mealTime = "Breakfast";
		} else if (hour >= 12 && hour < 17) {
			mealTime = "Lunch";
		} else {
			mealTime = "Dinner";
		}

		List<CartItem> list = new ArrayList<>();
		Connection connection = HungerConnection.getConnection();
		PreparedStatement ps = null;

		String update = "";
		if (!mealTime.equalsIgnoreCase("Breakfast") && !mealTime.equalsIgnoreCase("Lunch") && hour >= 12) {
			update = "select * from Cart_Items where user_id=? AND meal_time IN ('Dinner')";
		} else {
			update = "select * from Cart_Items where user_id=? AND meal_time=?";
		}

		ps = connection.prepareStatement(update);
		ps.setInt(1, userId2.getUserId());

		if (!mealTime.equalsIgnoreCase("Breakfast") && !mealTime.equalsIgnoreCase("Lunch") && hour >= 12) {
		} else {
			ps.setString(2, mealTime);
		}

		try {
			double overAllPrice = 0;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				int foodId = rs.getInt("food_id");
				int quantity = rs.getInt("quantity");
				double totalPrice = rs.getDouble("totalprice");
				String foodsession = rs.getString("meal_time");
				list.add(new CartItem(userId, foodId, quantity, totalPrice, foodsession));
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return list;
	}

	public boolean deleteCart(int foodId) throws ClassNotFoundException, SQLException {
		boolean rowDeleted;
		String cartdelete = "delete from Cart_Items where food_id=?";
		try (Connection connection = HungerConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(cartdelete);) {
			ps.setInt(1, foodId);
			rowDeleted = ps.executeUpdate() > 0;
			ps.close();
			connection.close();
		}
		return rowDeleted;
	}

	public Food getFoodId(Food food) throws ClassNotFoundException, SQLException {
		Connection connection = HungerConnection.getConnection();
		String query = "SELECT * FROM Food_Details WHERE hotel_name=?";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, food.getHotelName());
		ResultSet rs = p.executeQuery();
		if (rs.next()) {
			// Food food = new Food();
			food.setFoodId(rs.getInt("food_id"));
			food.setHotelId(rs.getInt("hotel_id"));
			food.setHotelName(rs.getString("hotel_name"));
			food.setFoodImage(rs.getBytes("food_image"));
			food.setFoodName(rs.getString("food_name"));
			food.setFoodPrice(rs.getInt("food_price"));
			food.setFoodCategories(rs.getString("food_catagories"));
			food.setFoodsession(rs.getString("meal_time"));
			return food;
		}
		return null;
	}

	public int updateFoodQuantity(int foodId, int quantity) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		int row = 0;

		try {
			connection = HungerConnection.getConnection();
			String query = "UPDATE Food_Details SET food_quantity = ? WHERE food_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, quantity);
			statement.setInt(2, foodId);
			row = statement.executeUpdate();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return row;
	}

	public void updateFoodQuantities(List<CartItem> cartItems) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = HungerConnection.getConnection();
			connection.setAutoCommit(false);
			for (CartItem cartItem : cartItems) {
				int foodId = cartItem.getFoodId();
				int quantity = cartItem.getQuantity();
				System.out.println("from implements :" + foodId + " " + quantity);
				String query = "UPDATE Food_Details SET food_quantity = food_quantity - ? WHERE food_id = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, quantity);
				statement.setInt(2, foodId);
				statement.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				connection.rollback();
			}
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.setAutoCommit(true);
				connection.close();
			}
		}

	}

	public int getRemainingFoodQuantity(int foodId) throws SQLException, ClassNotFoundException {
		int remainingQuantity = 0;
		try (Connection connection = HungerConnection.getConnection()) {
			String query = "SELECT food_quantity FROM Food_Details WHERE food_id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, foodId);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						remainingQuantity = resultSet.getInt("food_quantity");
						System.out.println(
								"Retrieved remaining quantity for food ID " + foodId + ": " + remainingQuantity);
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("Error while fetching remaining food quantity: " + e.getMessage());
			throw e;
		}
		return remainingQuantity;
	}

	public void updateCartItemQuantity(CartItem cartitem, int foodId, int quantity,double total)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = HungerConnection.getConnection();
			String updateQuery = "UPDATE Cart_Items SET quantity = ?,totalprice=? WHERE user_id = ? AND food_id = ?";
			ps = connection.prepareStatement(updateQuery);
			ps.setInt(1, quantity);
			ps.setDouble(2, total);
			ps.setInt(3, cartitem.getUserId());
			ps.setInt(4, foodId);

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Quantity updated successfully.");
			} else {
				System.out.println("No rows updated. Please check user or food ID.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public double getFoodPrice(int foodId) {
        Connection connection = null;
        PreparedStatement ps = null;
        double foodPrice=0;
try {
        connection = HungerConnection.getConnection();
        String updateQuery = "select food_price from Food_Details where food_id=?";
       
        ps = connection.prepareStatement(updateQuery);
 ps.setInt(1, foodId);
                    ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
             foodPrice = resultSet.getDouble("food_price");
            System.out.println("Retrieved remaining quantity for food ID " + foodId + ": " + foodPrice);
        }
    }catch (Exception e) {
    	e.printStackTrace();
    }
return foodPrice;
	}
}
