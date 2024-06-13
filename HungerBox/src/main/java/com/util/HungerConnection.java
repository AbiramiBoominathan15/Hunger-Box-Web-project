package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class HungerConnection {

		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/test_db_17", "root", "root");
			return connection;
		}

		
		
		
		
	}


