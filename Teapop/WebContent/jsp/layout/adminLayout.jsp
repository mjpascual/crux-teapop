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
		<link href="css/TableTools.css" rel="stylesheet">
		<link href="css/TableTools_JUI.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/TableTools.min.js"></script>
        <script type="text/javascript" src="js/ZeroClipboard.js"></script>
		<script src="js/admin.js"></script>
		<script type="text/javascript">
	        $(document).ready( function(){
	        	BodySwitcher.initBodySwitcher();
	        	AdminNavBehavour.initialize();
	        	$(document).ready(function () {
	                $.ajaxSetup({ cache: false });
	            });
	        });
        </script>
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
			<div id="body_container">
				<tiles:insertAttribute name="body" ignore="true" />
			</div>
		</article>
		<footer class="main">
			<tiles:insertAttribute name="footer" ignore="true" />
		</footer>
	</body>
</html>