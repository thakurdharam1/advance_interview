package com.rays.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Stored_ProcedureIn {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{call empIn(?)}");

		callStmt.setInt(1, 1);

		callStmt.execute();

		ResultSet rs = callStmt.getResultSet();

		while (rs.next()) { 

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));


		}
	}
}

//# Stored Procedure (in)
//==========================================================
//
//mysql> delimiter &&
//mysql> create procedure empIn(in c int)
//    -> begin
//    -> select * from emp where id = c;
//    -> end &&
//    
//mysql> set @input = 11;
//  
//mysql> call empIn(@input);