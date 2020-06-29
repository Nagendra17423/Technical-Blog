package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Entity;
import com.tech.blog.entities.Posts;
import com.tech.blog.helper.ConnectionProvider;

public class PostDao {
	Connection conn=null;
	
	public PostDao(ConnectionProvider connect) throws ClassNotFoundException, SQLException
	{
		conn=connect.dbconnect();
	
	}
	public ArrayList<Category> getCat() throws ClassNotFoundException, SQLException
	{
		String q="select * from category";
		PreparedStatement pstmt=conn.prepareStatement(q);
		ResultSet rs=pstmt.executeQuery();
		ArrayList<Category> cat=new ArrayList<>() ;
		while(rs.next()){
			Category c=new Category();
			c.setCtitle(rs.getString("ctitle"));
			c.setCid(rs.getInt("cid"));
			cat.add(c);
//System.out.println(c.getCtitle());
		}
		return cat;
	}

	public void insertPost( Posts p) throws ClassNotFoundException, SQLException

	{
		String q="insert into posts(ptitle,pcontent,pcode,ppic,catid,user_id) values(?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(q);
		pstmt.setString(1, p.getPtitle());
		pstmt.setString(2, p.getPcontent());
		pstmt.setString(3, p.getPcode());
		pstmt.setString(4, p.getPpic());
		pstmt.setInt(5, p.getCatid());
		pstmt.setInt(6, p.getUser_id());
		pstmt.executeUpdate();
		System.out.println("Executed properly from the db ");
		
		
	}

public List<Posts> getAllPost() throws SQLException
{
	List<Posts> post=new ArrayList<>();
	String q="select * from posts order by pid desc ";
	PreparedStatement pstmt =conn.prepareStatement(q);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
		Posts p=new Posts();
		p.setCatid(rs.getInt("catid"));
		p.setPcode(rs.getString("pcode"));
		p.setPcontent(rs.getString("pcontent"));
		p.setPdate(rs.getTimestamp("pdate"));
		p.setPid(rs.getInt("pid"));
		p.setPpic(rs.getString("ppic"));
		p.setPtitle(rs.getString("ptitle"));
		p.setUser_id(rs.getInt("user_id"));
		post.add(p);
	}
	return post;
	
}
public List<Posts> getPost(int catid) throws SQLException
{
	List<Posts> post=new ArrayList<>();
	String q="select * from posts where catid=?";
	PreparedStatement pstmt =conn.prepareStatement(q);
	pstmt.setInt(1, catid);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
		Posts p=new Posts();
		p.setCatid(rs.getInt("catid"));
		p.setPcode(rs.getString("pcode"));
		p.setPcontent(rs.getString("pcontent"));
		p.setPdate(rs.getTimestamp("pdate"));
		p.setPid(rs.getInt("pid"));
		p.setPpic(rs.getString("ppic"));
		p.setPtitle(rs.getString("ptitle"));
		p.setUser_id(rs.getInt("user_id"));
		post.add(p);
		
	}
	return post;

}

public Posts getpposts(int pid) throws SQLException
{
	Posts p=new Posts();
	String q="select * from posts where pid=?";
	PreparedStatement pstmt=conn.prepareStatement(q);
	pstmt.setInt(1, pid);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
		p.setPcode(rs.getString("pcode"));
	p.setPid(rs.getInt("pid"));
	p.setUser_id(rs.getInt("user_id"));
	p.setPcontent(rs.getString("pcontent"));
	p.setPdate(rs.getTimestamp("pdate"));
	p.setPpic(rs.getString("ppic"));
	p.setPtitle(rs.getString("ptitle"));
	}
	System.out.println("********************\npost id "+p.getPid()+"user id "+p.getUser_id()+"catid"+p.getCatid());

	return p;
}

public Entity getuser(int userid) throws SQLException {
	String q="select * from register where user_id=?";
	PreparedStatement pstmt=conn.prepareStatement(q);
	pstmt.setInt(1, userid);
	
	ResultSet rs=pstmt.executeQuery();
	Entity e=new Entity();
	while(rs.next()){
		e.setAbout(rs.getString("about"));
		e.setDate(rs.getTimestamp("rtime").toString());
		e.setEmail(rs.getString("mail"));
		e.setGender(rs.getString("gender"));
		e.setName(rs.getString("name"));
		e.setProfile(rs.getString("profile"));
	}
	// TODO Auto-generated method stub
	return e;
}




}
