package com.mindtree.bankaccountsapplication.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.bankaccountsapplication.exception.UtilityException;

public class DatabaseConnection {
	private static final String url = "jdbc:mysql://localhost:3306/bankaccountdb";
	private static final String username = "root";
	private static final String password = "Anilkarre8@";
	private static final String driver = "com.mysql.cj.jdbc.Driver";

	public static Connection DatabaseConnection() throws UtilityException {
		Connection connection = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new UtilityException("class not Found");
		}
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new UtilityException("SQL Syntax Error");
		}
		return connection;
	}

}
