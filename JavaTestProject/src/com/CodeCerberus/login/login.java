package com.CodeCerberus.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CodeCerberus.DAO.loginDao;
import com.CodeCerberus.utill.encryptions;

@WebServlet("/login")
public class login extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		
		String uname = request.getParameter("txtUsername");
		String pass = encryptions.encrypt(request.getParameter("txtPassword")); 
		
		loginDao dao = new loginDao();//call connection class
		
		if(dao.check(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			
			//cookie for users last login user name
			Cookie theCookie = new Cookie("LastUser", uname);
			theCookie.setMaxAge(60);
			response.addCookie(theCookie);
			
			//redirect to the next page
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("LoginPage.jsp");
		}
	}

}
