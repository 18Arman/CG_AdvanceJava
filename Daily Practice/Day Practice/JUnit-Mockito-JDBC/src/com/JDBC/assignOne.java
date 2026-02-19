package com.JDBC;
import java.sql.*;
public class assignOne {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/scott","root","Root@123");
			Statement st=cn.createStatement();
			//if table is already there then I have to drop it
			
			st.executeUpdate("drop table if exists student");
			//creating student table
			st.executeUpdate("Create table student(id INT Primary Key,"
					+ "sname varchar(100) not null,"
					+ "course varchar(100))");
			
			//inserting values in student table
			int rowsInserted=st.executeUpdate("Insert into student values(1,'Arman','B.tech'),"
					+ "(2,'Sanat','B.tech'),(3,'Saurabh','MCA')");
			System.out.println("Rows Inserted are:"+rowsInserted);
			
			//reading the data of student table before updation
			ResultSet rs=st.executeQuery("Select * from student");
			System.out.println("ID-NAME---COURSE");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getString("course"));
			}
			
			//Updating student table
			int rowUpdate=st.executeUpdate("update student set course='data science' where id=1");
			System.out.println("Number of updated rows are:"+rowUpdate);
			
			//reading the data of student table after updation
			rs=st.executeQuery("Select * from student");
			System.out.println("ID-NAME---COURSE");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getString("course"));
			}
			
			//deleting data
			int rowdelete=st.executeUpdate("delete from student where id=1");
			System.out.println("Number of deleted rows are:"+rowdelete);
			
			//reading the data of student table after deletion
			rs=st.executeQuery("Select * from student");
			System.out.println("ID-NAME---COURSE");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getString("course"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
