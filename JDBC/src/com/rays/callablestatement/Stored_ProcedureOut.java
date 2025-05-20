package com.rays.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Stored_ProcedureOut {
	public static void main(String[] args) throws Exception {

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL empOut(?)}");

		callStmt.registerOutParameter(1, Types.INTEGER);

		callStmt.execute();

		int resultValue = callStmt.getInt(1);

		System.out.println("Result from empOut stored procedure: " + resultValue);

	} catch (Exception e) {

		e.printStackTrace();
		}
	}
}


//# Stored Procedure (out)
//==========================================================
//
//mysql> delimiter &&
//mysql> create procedure empOut(out c int)
//    -> begin
//    -> select salary into c from emp where id = 10;
//    -> end &&
//    
//mysql> call empOut(@output);
//
//mysql> select @output;    
//  