package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Connection {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		Statement psmt = con.createStatement();

		// PreparedStatement psmt = con.prepareStatement("Select * from emp");

		// ResultSet rs = stmt.executeQuery("Select *from person");

		ResultSet rs = psmt.executeQuery("select * from emp");
		while (rs.next()) {
			// Access by column index starting from 1
			int id = rs.getInt(1);
			// Access by column name
			String name = rs.getString("emp_name");

			int salary = rs.getInt(3);
			System.out.println(id + " -> " + name + " -> " + salary);

		}

//		stmt.close();
		con.close();
	}
}