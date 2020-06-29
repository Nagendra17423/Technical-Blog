package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	String name="postgres";
	String password="NAGENDRA1@1999";
	String url="jdbc:postgresql://localhost:5432/Blog";
	String  driver="org.postgresql.Driver";
	Connection conn=null;
	public Connection dbconnect() throws SQLException, ClassNotFoundException
	{
//		Class.forName("org.postgresql.Driver");
		Class.forName(driver);
		 conn= DriverManager.getConnection(url,name,password);
		 if(conn==null)
			 System.out.println("null");
		 else
			 System.out.println("sucessfully connected ");
		          return conn;
	}

}
