package com.training.project.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionFactory {
	public static Connection getMySqlConnection(){
		Connection con=null;
		
		try {
			ResourceBundle bundle=ResourceBundle.getBundle("application");
			
			String url=bundle.getString("datasource.url");
			String userName=bundle.getString("datasource.username");
			String passWord=bundle.getString("datasource.password");
			con=DriverManager.getConnection(url,userName,passWord);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
