<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<meta charset="utf-8">
		<!-- saved from url=(0014)about:internet -->
		<title>Tea-Pop Admin</title>
		<link href="css/admin.css" rel="stylesheet">
		<script src="js/admin.js"></script>
	</head>
	<body class="login">
		<header class="login" >
			<img src="images/admin/logo1.jpg" title="TeaPop"></div>
		</header>
		<article class="login">
			<fieldset>
				<aside>
					<img src="images/admin/login.png" title="Administration">
				</aside>
				<section>
					<label for="username">Username:</label><br>
					<input type="text" id="username" name="username" autofocus required><br>
					<label for="password">Password:</label><br>
					<input type="password" id="password" name="password" autofocus required><br>
					<a href="#">Forgotten Password</a><br>
					<div class="submitLogin">
						<form action="admin/main.html" method="get">
							<input class="button" type="submit" value="Login"></input>
						</form>
					</div>
				</section>
			</fieldset>
		</article>
		<footer class="login">
			<a href="#">UPOU-CRUX</a> &#169; 2014 All Rights Reserved. <br>
			Version 1.0.0
		</footer>
	</body>
</html>