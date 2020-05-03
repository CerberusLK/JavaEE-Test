package com.CodeCerberus.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CodeCerberus.DAO.signupDao;
import com.CodeCerberus.utill.encryptions;

@WebServlet("/signup")
public class signup extends HttpServlet {
	
	encryptions encry = new encryptions();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname= request.getParameter("txtFullName");
		String email= request.getParameter("txtEmail");
		String username= request.getParameter("txtUserName");
		String pass= encryptions.encrypt(request.getParameter("txtPassword"));
		
		signupDao dao = new signupDao();
		try {
			dao.signupData(username, email, fullname, pass);
			response.sendRedirect("LoginPage.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
