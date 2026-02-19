package com.JDBC;
import java.sql.*;
public class JdbcExample {
	public static void main(String args[]) throws ClassNotFoundException {
		try {
			//driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection connection= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/scott",
					"root",  //username
					"Root@123"  //password
					);
			//create statement
			Statement statement= connection.createStatement();
			ResultSet resultset= statement.executeQuery("select * from emp;");
			while(resultset.next()) {
				System.out.println(resultset.getInt("empno")+" : -> "+resultset.getString("ename"));
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

