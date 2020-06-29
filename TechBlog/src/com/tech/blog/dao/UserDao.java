package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.tech.blog.entities.Entity;
import com.tech.blog.helper.ConnectionProvider;

public class UserDao {
	private Connection conn=null;
	Date date=new Date();
	public UserDao(ConnectionProvider connect) throws ClassNotFoundException, SQLException
	{
		conn=connect.dbconnect();
	}
	public void saveuser(Entity e) throws SQLException {
		// TODO Auto-generated method stub
		String q="insert into register(name,mail,password,gender,about) values(?,?,?,?,?) ";
		PreparedStatement pstmt=conn.prepareStatement(q);
		pstmt.setString(1,e.getName());
		pstmt.setString(2, e.getEmail());
		pstmt.setString(3, e.getPassword());
		pstmt.setString(4, e.getGender());
		pstmt.setString(5, e.getAbout());
		
		System.out.println(e.getAbout()+" "+e.getEmail()+" "+e.getGender()+" "+e.getName()+" "+e.getPassword()+" "+e.getClass());
		pstmt.executeUpdate();
	}
	public Entity getuser(String email,String password) throws ClassNotFoundException, SQLException
	{
		Entity user=null;
		String q="select * from register where mail=? and password=?";
		PreparedStatement pstmt=conn.prepareStatement(q);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			user=new Entity();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("mail"));
			user.setGender(rs.getString("gender"));
			user.setPassword(rs.getString("password"));
			user.setAbout(rs.getString("about"));
			user.setDate(rs.getString("rtime"));
			user.setProfile(rs.getString("profile"));
			user.setUser_id(new Integer(rs.getString("user_id")));
		}
		return user;
	}
	
	public void updateEntity(Entity e) throws ClassNotFoundException, SQLException
	{
		String q="update register set name=?,about=?,profile=?,mail=? where mail=?";
		PreparedStatement pstmt=conn.prepareStatement(q);
		pstmt.setString(1,e.getName());
		pstmt.setString(2, e.getAbout());	
		pstmt.setString(3, e.getProfile());
		pstmt.setString(4, e.getEmail());
		pstmt.setString(5, e.getEmail());
		pstmt.executeUpdate();
		
		
	}

}
