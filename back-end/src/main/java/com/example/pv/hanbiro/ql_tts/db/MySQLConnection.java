package com.example.pv.hanbiro.ql_tts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/DB_ql_tts";
		String userName = "root";
		String password = "12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			return DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return null;
	}
}
