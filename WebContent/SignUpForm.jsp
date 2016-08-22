<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<body>
		<div><h2 align="right"><a href="/SpringAndMongpDBLoginModule/SignIn.html">Sign In</a></h2></div>
		<form:errors path="userregistration1.*"/>
		<h2>Fill Below Details!!!</h2>
		<form action="/SpringAndMongpDBLoginModule/completeRegistration.html" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPassword"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="userEmail"/></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="userMobile"/></td>
				</tr>
			</table>
			<input type="submit" value="Register"/>
			${message}
		</form>
	</body>
</html>