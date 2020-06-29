package com.tech.blog.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.PostDao;
import com.tech.blog.dao.likedao;
import com.tech.blog.entities.Entity;
import com.tech.blog.entities.Posts;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class LikeServlet
 */
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		int pid=Integer.parseInt(request.getParameter("pid").trim());
		
		try {
			likedao like=new likedao( new ConnectionProvider());
			like.setlike(uid, pid);
			request.setAttribute("like", like.getlike(pid));
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PostDao post;
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
			Entity e=post.getuser(uid);
			request.setAttribute("currentusr", e);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
