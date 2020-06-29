package com.tech.blog.servlets;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Entity;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("user-name");
		String  email=request.getParameter("user-mail");
		String about=request.getParameter("user-about");
		Part part=(Part)request.getPart("user-pic");
		String picname=part.getSubmittedFileName();
		System.out.println("name"+name+"email"+email+"about "+about+"picname "+picname);
		 HttpSession session=request.getSession();
		 Entity e=(Entity) session.getAttribute("user");
		 e.setAbout(about);
		 e.setEmail(email);
		 e.setName(name);
		 e.setProfile(picname);
		 String oldfilename=request.getParameter("oldfilename");
		 String oldpath=request.getSession().getServletContext().getRealPath("/")+"pics"+File.separator+oldfilename;
		 if(oldfilename.compareTo("default.png")!=0)
            Helper.delete(oldpath);
		 
		 
		 try {
			UserDao dao=new UserDao(new ConnectionProvider());
			dao.updateEntity(e);
			System.out.println("updated in db");
//			String path=request.getRealPath("/")+"pics"+File.separator+user.getProfile();
			HttpSession ses=request.getSession();
			Entity u1=(Entity) ses.getAttribute("user");
			String uploadPath =request.getSession().getServletContext().getRealPath("/")+"pics"+File.separator+u1.getProfile();
			System.out.println(uploadPath);
			
			 
			 System.out.println("deleted ");
			 Helper.addFile(part.getInputStream(), uploadPath);
			 System.out.println("new file added ");
			
			
	                
			
			request.getRequestDispatcher("profile.jsp").forward(request, response);
			
		} 
		 catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		
		
	}

}
