<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Tea-Pop Admin</title>
		<link href="css/admin.css" rel="stylesheet">
		<script src="js/admin.js"></script>
	</head>
	<body class="main">
		<header class="main" >
			<tiles:insertAttribute name="title" ignore="true" />
		</header>
		<article class="main">
			<aside>
				<nav>
					<tiles:insertAttribute name="nav" ignore="true" />
				</nav>	
			</aside>
			<tiles:insertAttribute name="body" ignore="true" />
		</article>
		<footer class="main">
			<tiles:insertAttribute name="footer" ignore="true" />
		</footer>
	</body>
</html>