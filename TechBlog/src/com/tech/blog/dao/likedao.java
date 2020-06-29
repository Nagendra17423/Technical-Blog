package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tech.blog.helper.ConnectionProvider;

public class likedao {
	
	Connection conn=null;
	public likedao(ConnectionProvider connect) throws ClassNotFoundException, SQLException
	{
		conn=connect.dbconnect();
		
	}
	public void setlike(int uid,int pid) throws SQLException
	{
		String q="insert into postlike(uid,pid) values(?,?) ";
		PreparedStatement pstmt=conn.prepareStatement(q);
		pstmt.setInt(1, uid);
		pstmt.setInt(2, pid);
		
        pstmt.executeUpdate();
		
	}
	public int getlike(int pid) throws SQLException
	{
		int count=0;
		String q="select count(*) as c from postlike where pid=?";
		PreparedStatement pstmt=conn.prepareStatement(q);
		pstmt.setInt(1, pid);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			count=rs.getInt("c");
		}
		
		return count;
		
	}

}
