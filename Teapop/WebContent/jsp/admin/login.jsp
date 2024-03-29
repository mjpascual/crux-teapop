<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<meta charset="utf-8">
		<!-- saved from url=(0014)about:internet -->
		<title>Tea-Pop Admin</title>
		<link href="css/admin.css" rel="stylesheet">
		<script src="js/admin.js"></script>
	</head>
	<body class="login">
		<div class="login">
			<header class="login" >
				<img src="images/admin/logo1.jpg" title="TeaPop">
			</header>
			<article class="login">
				<fieldset>
					<div class="aside">
						<img src="images/admin/login.png" title="Administration">
					</div>
					<div class="section">
						<form action="loginUser" method="post">
							<label for="username">Username:</label><br>
							<input type="text" id="username" name="user.username" autofocus required><br>
							<label for="password">Password:</label><br>
							<input type="password" id="password" name="user.password" required><br>
<!-- 							<a href="#">Forgotten Password</a> -->
							<br>
							<div class="submitLogin">
								<input class="button" type="submit" value="Login"></input>
							</div>
						</form>
					</div>
					<s:if test="hasActionErrors()">
						<div class="login_errors">
							<s:actionerror/>
						</div>
					</s:if>
				</fieldset>
			</article>
			<footer class="login">
				<a href="#">UPOU-CRUX</a> &#169; 2014 All Rights Reserved. <br>
				Version 1.0.0
			</footer>
		</div>
	</body>
</html>