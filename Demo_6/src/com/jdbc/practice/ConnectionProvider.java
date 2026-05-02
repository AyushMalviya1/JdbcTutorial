package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection connection;
	public static Connection getConnection() {
		try {
			if(connection == null) {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbctutorial", "root", "root");
			System.out.println("Connection established");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
}
