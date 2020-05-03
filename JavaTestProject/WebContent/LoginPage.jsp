<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<!-- Cookie for last login user name -->
<%
		String lastUser = "";
	Cookie[] theCookies = request.getCookies();
	if (theCookies != null) {
		for (Cookie tempCookie : theCookies) {
			if("LastUser".equals(tempCookie.getName())){
				lastUser = tempCookie.getValue();
				break;
			}
		}
	}
	%>
	<form action="login" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="txtUsername" placeholder="Username" value=<%= lastUser %> ></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtPassword" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>