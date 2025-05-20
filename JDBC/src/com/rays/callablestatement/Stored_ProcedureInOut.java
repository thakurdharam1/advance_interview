package com.rays.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Stored_ProcedureInOut {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL empInOut(?)}");

		callStmt.setInt(1, 1);

		callStmt.registerOutParameter(1, Types.INTEGER);

		callStmt.execute();

		System.out.println(callStmt.getInt(1));
	}
}

//
//# Stored Procedure (inout)
//==========================================================
//
//mysql> delimiter &&
//mysql> create procedure empInOut(inout c int)
//    -> begin
//    -> select salary into c from emp where id = c;
//    -> end &&
//    
//mysql> set @inout = 1;
//
//mysql> call empInOut(@inout);
