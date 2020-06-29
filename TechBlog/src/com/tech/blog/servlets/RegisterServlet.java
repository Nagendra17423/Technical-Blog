package com.tech.blog.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Entity;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" from register page ");
		if(request.getParameter("check")==null)
		{
			//check out  terms and conditions.....
			System.out.println(" check is null "); 
		}
		else
		{
			UserDao dao;
			try {
				dao = new UserDao(new ConnectionProvider());
				Entity e=new Entity();
				e.setName(request.getParameter("name"));
				e.setPassword(request.getParameter("password"));
				e.setAbout(request.getParameter("about"));
				e.setEmail(request.getParameter("email"));
				e.setGender(request.getParameter("gender"));
				dao.saveuser(e);
				System.out.println(" updated from servlet page ");
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
