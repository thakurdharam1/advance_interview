package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CRUD_Operation {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance","root","root");
		
		Statement stmt = con.createStatement();
		//Insert
		int i = stmt.executeUpdate("insert into emp values(12,'kapil',15)");
//		System.out.println(i);
		
//		
		//Update
//		int i = stmt.executeUpdate("Update emp set emp_name='Hari' where emp_salary=15000" );
//		System.out.println(i);
//		
		//Delete
		int i = stmt.executeUpdate("delete from emp where emp_salary=15" );
		System.out.println(i);
		
		//Create,Alter,Drop  Table 
		//String sql = "create table emp (id int not null,Name varchar(90),age int)";
		//stmt.executeUpdate(sql);
		
	}

}
