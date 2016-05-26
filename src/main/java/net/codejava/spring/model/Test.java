package net.codejava.spring.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static void main(String args[]){
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/eahealth","root","my_sql_amit");  
			  
			//here sonoo is database name, root is username and password  
			  
			Statement stmt=con.createStatement();  
			  
			ResultSet rs=stmt.executeQuery("select * from bmi_chart");  
			  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			  
			}  
			

	}
		
	

