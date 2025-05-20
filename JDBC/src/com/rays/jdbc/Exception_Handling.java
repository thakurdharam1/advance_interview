
package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exception_Handling {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

			stmt = con.createStatement();
	
			
		
		} catch (SQLException e) {

			System.out.println("Error  ->  " + e.getMessage());
			System.out.println("Cause  ->  "+e.getCause());
			System.out.println("SQL State  ->  "+e.getSQLState());
			System.out.println("Error Code  ->  "+e.getErrorCode());

		}
	}
}
