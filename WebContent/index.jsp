<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<body>
		New User,<a href="./signUpHere.html">Click Here for registration</a>
		
		<h2>Login Here</h2>
		<form action="./loginPair.html" method="post">
			<table>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="userEmail"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPassword"/></td>
				</tr>
			</table>
			<input type="submit" value="LogIn"/>
			${message}
		</form>
		<a href="./forgotPassword.html">Forgot Password??</a>
	</body>
</html>