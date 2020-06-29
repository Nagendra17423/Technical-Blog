package com.tech.blog.servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Entity;
import com.tech.blog.helper.ConnectionProvider;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("email");
		String password=request.getParameter("password");
		UserDao dao;
		try {
			dao = new UserDao(new ConnectionProvider());
			Entity e=dao.getuser(mail,password);
			if(e==null)
			{
				request.setAttribute("msg", "Invalid Credentials");
				request.getRequestDispatcher("Login-page.jsp").forward(request, response);
			}
			else{
				System.out.print("successfully loged in");
				HttpSession session=request.getSession();
				session.setAttribute("user", e);
				request.getRequestDispatcher("profile.jsp").forward(request, response);
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
