package com.DAO;

import java.sql.SQLException;

import com.model.UserDetails;

	public interface HungerDAO {

		public void adminLogin(String name ,String password) throws ClassNotFoundException, SQLException;

		
		
		
	}


