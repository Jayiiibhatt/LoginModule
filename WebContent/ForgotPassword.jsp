<html>
	<body>
	<div><h2 align="right"><a href="/SpringAndMongpDBLoginModule/SignIn.html">Sign In</a></h2></div>
		<h2>forgot password!!!Give Below And Update Password</h2>
		<form action="/SpringAndMongpDBLoginModule/updateYourPassword.html" method="post">
			<table>
				<tr>
					<td>Email</td>
					<td><input type="text" name="userEmail"/></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="userMobile"/></td>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPassword"/></td>
				</tr>
			</table>
			<input type="submit" value="Update"/>
			${message}
		</form>
	</body>
</html>