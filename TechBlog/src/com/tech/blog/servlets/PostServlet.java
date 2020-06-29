package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Entity;
import com.tech.blog.entities.Posts;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class PostServlet
 */
@MultipartConfig
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String content = request.getParameter("content");
		System.out.println("request " + request.getParameter("choice"));
		int catid = Integer.parseInt(request.getParameter("choice"));
		Part imagepart = request.getPart("pic");
		String image = imagepart.getSubmittedFileName();
		Posts p = new Posts();
		p.setCatid(catid);
		
		p.setPcode(code);
		
		p.setPcontent(content);
		
		p.setPpic(image);
		
		p.setPtitle(title);
		
		HttpSession session = request.getSession();
		Entity e = (Entity) session.getAttribute("user");
		p.setUser_id(e.getUser_id());
		System.out.println("user_id " + e.getUser_id() + "\n**********\n");
		PostDao post;
		System.out.println("p object "+p);
		try {
			post = new PostDao(new ConnectionProvider());
			post.insertPost(p);
			System.out.println("Sucessfully post added ");
			
			String uploadPath =request.getSession().getServletContext().getRealPath("/")+"Blog_pics"+File.separator+p.getPpic();
			System.out.println(uploadPath);
			
			 Helper.addFile(imagepart.getInputStream(), uploadPath);
			 System.out.println("new file added ");
			 request.getRequestDispatcher("profile.jsp").forward(request, response);

			
			
			
			

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
