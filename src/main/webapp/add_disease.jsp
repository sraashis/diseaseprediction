<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="resources/bootstrap/css/my_design.css">
	    <link rel="stylesheet" href="resources/bootstrap/css/styles.css">
		
	
		<link rel="icon" href="resources/images/icons/home-icon.png">
		<title>healthGuide</title>
	</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<nav class="navbar navbar-static">
   <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="home" target="ext"><b>healthGuide</b></a>
      <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="glyphicon glyphicon-chevron-down"></span>
      </a>
    </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav"> 
          <li><a href="home"> <span class="glyphicon glyphicon-home"></span></a></li> 
          <li><a href="#">Specialized Hospital</a></li>
          <li><a href="#">General Hospital</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Category <span class="glyphicon glyphicon-chevron-down" style="font-size: 14px"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Elite</a></li>
              <li><a href="#">Economical</a></li>
              <li><a href="#">Public</a></li>
              
              
            </ul>
          </li>
        </ul>
        <ul class="nav navbar-right navbar-nav">
	          <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-search"></i></a>
	            
		            <ul class="dropdown-menu" style="padding:12px;">
			            <li>
				            <form class="form-inline">
				     				<button type="submit" class="btn btn-default pull-right"><i class="glyphicon glyphicon-search"></i></button><input type="text" class="form-control pull-left" placeholder="Search">
				            </form>
			            </li>
		            </ul>
	             
	         	 </li>
          
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">About <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="dropdown-menu">
	              <li><a href="#">FAQs</a></li>
	              	<li><a href="#">Team</a></li>
	              	<li><a href="#">About</a></li>
	              <c:if test="${sessionScope.user !=null }">
	              	<li class="divider"></li>
	              	<li><a href="add-disease"><span class="glyphicon glyphicon-plus-sign"></span> Add Disease</a></li>
				  	<li><a href="add-hospital"><span class="glyphicon glyphicon-plus-sign"></span> Add Hospital</a></li>
	              </c:if>
             </ul>
          </li>
          
          <li>
	          <c:choose>
					 <c:when test="${ sessionScope.user != null}">
					       <a href="logout"><span class="glyphicon glyphicon-user"></span> Logout</a>
					    </c:when>
					  <c:otherwise>
					       <a href="#" id="login_link"><span class="glyphicon glyphicon-user"></span> Login</a>
					       <c:import url="resources/templates/login.jsp" />
					    </c:otherwise>
			 </c:choose>
			</li>
        </ul>
      </div>
    </div>
</nav><!-- /.navbar -->

<header class="masthead" >
  <div class="container">
    <div class="row row-centered">
    		<div class="col-md-2">
    			<img title="Stethoscope" alt="Stethoscope" src="resources/images/icons/stethoscope-icon.png" height="80px"></img>
    		</div>
			<div class="col-md-6 " >
		        <h1>Prevention is better than cure.</h1>
          		<h4><lead>Most of Diseases are <lead>curable if identified early</h4></p>
      		</div>
      		<div class="col-md-4">
      			<div class="fb-like" data-href="http://localhost:8080/healthGuide" data-layout="button_count" data-action="like" data-show-faces="true" data-share="true"></div>
      			<a href="http://twitter.com"><img title="Twitter" alt="Twitter" src="resources/images/icons/twitter-icon.png" height="40px"></img></a>
      			<a href="http://google.com"><img title="Google plus" alt="Google plus" src="resources/images/icons/google-plus-icon.png" height="40px"></img></a>
      		</div>
    </div>
  </div>
  
</header>

<!-- Begin Body -->
	<div class="container">
		<div class="no-gutter row row-centered">
		
      		
      		
	      	
      		
	      	<!-- right content column-->
	        <div class="col-md-8 col-centered" id="content">
            	<div class="panel">
	    			<div class="panel-heading" style="background-color:green;color:#fff;">Training</div>   
	              	<div class="panel-body">
	                  
			               <div class="row">
			                  <div class="col-md-12">
				                  <div class="well">
				                  	<div style="display:none;">
														<c:out value="${docNum }" default="0" />
														<!-- 
															At first clicking to add disease does not create a docNumber variable
															so we need to check that and create one using 
														 -->	
														<c:if test="${docNum==null }">
															<c:set var="docNum" value="0" />
														</c:if>
												</div>
				                        <c:choose>
												<c:when test="${docNum==0 }">
												<div class="row row-centered">
													
													<form action="add" method="get" role="form">
														<div class="form-group col-md-4 col-centered">
															<input type="text" class="form-control" name="diseaseName" placeholder="Disease Name" required="required"/> <br >
															<input type="number" class="form-control" name="docCount" placeholder="Number of Training Docs" required="required" min="0" max="5" value="5"/> 
															<br/><input class="btn btn-lg btn-success center-block"  type="submit" value="Set">
														</div>
													</form>
													
												</div>
												</c:when>
												
												<c:otherwise>
													<div><h2>${diseaseName }</h2></div><br />
													<form action="train" method="post" role="form">
														<input type="hidden" class="form-control" name="diseaseName" value="${diseaseName }" />
														<input type="hidden" class="form-control" name="docCount" value="${docNum }"  />
														<div class="form-group col-md-12 col-centered">
															<fieldset class="training_border">
																<legend>Training Docs Here</legend>
																<c:forEach begin="1" end="${docNum }" step="1" varStatus="indexCount">
																		<textarea class="form-control" rows="6" cols="80" placeholder="Paste training document here" name="doc${indexCount.count }" required="required"></textarea>
																		<br />
																</c:forEach>
															</fieldset>
															<fieldset class="training_border">
																<legend>About ${diseaseName }</legend>
																<textarea class="form-control" rows="8" cols="80" placeholder="About Disease" name="aboutDisease" required="required"></textarea>
															</fieldset>
															
															<br />
															<input class="btn btn-lg btn-success center-block" type="submit" value="Train"/>
														</div>
													</form>
												</c:otherwise>	
										</c:choose>  
				                  </div>
			                  </div>
			                </div>
	                
			                  
			                
	                  
	                  </div><!--/panel-body-->
                </div><!--/panel-->
              	<!--/end right column-->
      	</div> 
  		
  		</div>
	</div>
	<footer>
	  <div class="container">
	  	<div class="row">
	      <div class="col-md-12 text-right"><h5>© Disease Prediction System Group Kathford 2015</h5></div>
	    </div>
	  </div>
	</footer>


		<script src="resources/bootstrap/js/jquery.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="resources/bootstrap/js/jquery_script.js"></script>
		<script src="resources/bootstrap/js/script.js"></script>
	</body>
</html>