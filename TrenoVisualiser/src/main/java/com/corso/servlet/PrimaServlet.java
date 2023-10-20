package com.corso.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index.html")
public class PrimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); 

       // String name2 = (String)request.getAttribute("name"); 
		
		System.out.println(name); 
		
		response.getWriter().append("<h1 style=\"background-color:lightgreen\">Benvenuti! </h1>"
				+ "<p style=\"font-size:2rem\"> La porta è: " + request.getLocalPort() + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
