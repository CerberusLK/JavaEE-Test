package com.CodeCerberus.DAO;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class signupDao {
	String user = "root";
	String password = "";
	String url = "jdbc:mysql://localhost:3306/java";
	String sql = "insert into user values (?,?,?,?);";

	public void signupData(String username, String email, String fullName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, user,"");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, email);
			st.setString(3, fullName);
			st.setString(4, password);
			st.executeUpdate();
			System.out.println("New user added successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
