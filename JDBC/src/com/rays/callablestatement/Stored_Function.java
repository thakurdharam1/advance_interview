package com.rays.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Stored_Function {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		CallableStatement callStmt = con.prepareCall("{? = CALL square(?)}");
		callStmt.setInt(2, 10);
		callStmt.registerOutParameter(1, Types.INTEGER);
		callStmt.execute();

		System.out.println(" Square " + callStmt.getInt(1));

	}
}



//========================================================== 
//# Stored Function
//==========================================================
//
//mysql> delimiter &&
//mysql> create function square(num int)
//    -> returns int
//    -> deterministic
//    -> begin
//    -> declare result int;
//    -> set result = num * num;
//    -> return result;
//    -> end &&
//    
//mysql> select square(10);
//
