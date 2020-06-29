package com.tech.blog.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.PostDao;
import com.tech.blog.dao.likedao;
import com.tech.blog.entities.Entity;
import com.tech.blog.entities.Posts;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class Singlepost
 */
public class Singlepost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int pid=Integer.parseInt(request.getParameter("pid")); 
//		HttpSession session=request.getSession();
//		Entity e=(Entity)session.getAttribute("user");
//		System.out.println("user "+e);
//		request.setAttribute("user",e);
		PostDao post;
		int userid=Integer.parseInt(request.getParameter("user_id"));
		try {
			post = new PostDao(new ConnectionProvider());
			Posts p=post.getpposts(pid);
			request.setAttribute("post", p);
//			System.out.println("post from dao "+p);

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			post=new PostDao(new ConnectionProvider());
			Entity e=post.getuser(userid);
			request.setAttribute("currentusr", e);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			likedao like=new likedao( new ConnectionProvider());
			request.setAttribute("like", like.getlike(pid));
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		request.getRequestDispatcher("single_post.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
