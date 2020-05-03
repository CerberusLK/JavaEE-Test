<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");//for http 1.1 and above
	if (session.getAttribute("username") == null) {
		response.sendRedirect("LoginPage.jsp");
	}
	%>
	Welcome user ${username}
	<a href="videos.jsp">To Videos</a>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>