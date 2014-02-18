<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />

        <title>Tea Pop Online</title>

        <!-- Our CSS stylesheet file -->
        <link rel="stylesheet" href="teapop/css/960.css" />
        <link rel="stylesheet" href="teapop/css/header.css" />
        <link rel="stylesheet" href="teapop/css/teapop.css" />
        <link rel="stylesheet" href="teapop/css/footer.css" />
        <link rel="stylesheet" href="teapop/css/contactus.css" />
		<link rel="stylesheet" href="teapop/css/location.css" />
		<link rel="stylesheet" href="teapop/css/promo.css" />
		
		
        
        <!-- Including the Lobster font from Google's Font Directory -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster" />

        <!-- Enabling HTML5 support for Internet Explorer -->
        <!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="teapop/js/jsviews.js"></script>
        <script type="text/javascript" src="teapop/js/EventHandler.js"></script>
        <script type="text/javascript" src="teapop/js/ContentHandler.js"></script>
        <script type="text/javascript">
        $(document).ready( function(){
        	EventHandler.initTopMenu();
        	ContentHandler.show("home");
        });
        </script>
        
    </head>
	
    <body id="teapopBody" style="background:  url(teapop/images/background.jpg)">
    	
    	<div id="wrap" class="boxed container_16"> <!--START DIV BODY-->
         	
         	<!-- HEADER -->
         	<tiles:insertAttribute name="header" ignore="true" />
         	<!-- HEADER -->	
         		
         	<!--CONTENT-->
         	<div id="content_wrapper" class="main_content grid_16">
         		<tiles:insertAttribute name="body" ignore="true" />
         	</div>
         	<!--CONTENT-->
         
         </div> <!--END DIV FOR BODY-->
        
       
       <!--FOOTER --> 
        <div style="clear: both"></div>
        <tiles:insertAttribute name="footer" ignore="true" />
    </body>
</html>