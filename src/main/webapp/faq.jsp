<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
	<meta name="view-port" charset="utf-8" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/bootstrap/css/my_design.css">
	<script src="resources/bootstrap/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/bootstrap/js/jquery_script.js"></script>
	
	
	<link rel="stylesheet" type="text/css" href="resources/css/design.css">
<link rel="icon" href="resources/images/hospital.ico">
<title>FAQs</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid" id="navigator">
			<div class="navbar-header">
				<a class="navbar-brand" href="home" id="nav_header"><span class="glyphicon glyphicon-plus"></span>healthGuide</a>
			</div>
			<div>
				<ul class="nav navbar-nav" role="tablist">
						<c:import url="resources/templates/static_menu.jsp"/>
			 	</ul>
			 	<ul class="nav navbar-nav navbar-right">
				 		<li class="dropdown">	
				 			<c:if test="${sessionScope.user != null}">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#">Update<span class="caret"></span></a>
						          <ul class="dropdown-menu">
						            <li><a href="add-disease"><span class="glyphicon glyphicon-plus-sign"></span> Add Disease</a></li>
						            <li><a href="add-hospital"><span class="glyphicon glyphicon-plus-sign"></span> Add Hospital</a></li>
						          </ul>
							</c:if>
						</li>
			        <li>
			        	<c:choose>
			        		<c:when test="${ sessionScope.user != null}">
			        			<a href="logout"><span class="glyphicon glyphicon-log-out"> Logout</span></a>
			        		</c:when>
			        		<c:otherwise>
			        			<a href="#" id="login_link"><span class="glyphicon glyphicon-log-in"> Login</span></a>
			        			<c:import url="resources/templates/login.jsp" />
			        		</c:otherwise>
			        	</c:choose>
			        	
			        </li>
			    </ul>
			</div>	
				
		</div>
	</nav>
	
	<div class="container">
		
		
		
	</div>
	
	<div id="footer" class="clear_float">
			<c:import url="resources/templates/footer.jsp"/>
	</div>
</body>
</html>