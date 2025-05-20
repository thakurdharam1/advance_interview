package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction_Handling {
	public static void main(String[] args) throws Exception {

		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

			// con.setAutoCommit(false); ka matlab hai ki ab ye operations tab tak commit
			// nahi honge jab tak aap explicitly con.commit(); nahi likhenge. Isse ek saath
			// multiple operations ko ek transaction me wrap kiya jata hai.
			con.setAutoCommit(false);

			
			stmt = con.createStatement();
			// Update data into the account table within a transaction
//			stmt.executeUpdate("update account set balance=1500 ,name='jatin' where id=2");
//			stmt.executeUpdate("update account set balance=balance+1500,name='naman' where id=3");

			// Insert data into the account table within a transaction
			int i = stmt.executeUpdate("insert into account  values (66,'kapil', 1000)");
			i = stmt.executeUpdate("INSERT INTO account (id, name, balance) VALUES (93,'paras', 1500)");

			// Delete data into the account table within a transaction
			// Perform the DELETE operation - delete an account with id = 3
			// stmt.executeUpdate("DELETE FROM account WHERE id = 3");

			// Perform another operation (for example, another delete or any other query)
			// stmt.executeUpdate("DELETE FROM account WHERE id = 4");

			con.commit();
			System.out.println("Data Inserted...!!!" + i);
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();

			System.out.println("check ..........");
		} finally {
			stmt.close();
			con.close();
		}
	}

}
