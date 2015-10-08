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
          <li><a href="home"><span class="glyphicon glyphicon-home"></span></a></li> 
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
		<div class="no-gutter row">
		
      		<!-- left side column -->
	  		<div class="col-md-2">
	              	<div class="panel panel-default" id="sidebar">
	                <div class="panel-heading" style="background-color:#00b900; ;color:#fff;">Top Hospitals</div> 
	                <div class="panel-body">
	      			<ul class="nav nav-stacked">
	                    <li><a href="#">Bharatpur Cancer Hospital</a></li>
	          			<li><a href="#">Tilganga Eye Hospital</a></li>
	                  	<li><a href="#">Tuberclosis Center</a></li>
	          			<li><a href="#">Sahid Gangalal Hridaya Kendra</a></li>
	                  	<li><a href="#">Bir Hospital</a></li>
	          			<li><a href="#">Teaching Hospital</a></li>
	          			<li><a href="#">Grandy Hospital</a></li>
	          			<li><a href="#">Norvic Hospital</a></li>
	                  	<li><a href="#">Kmc Hospital</a></li>
	          			<li><a href="#">BnB Hospital</a></li>
	          			<li><a href="#">Vayodha Hospital</a></li>
	          			<li><a href="#">Global Hospital</a></li>
	          			<li><a href="#">Nobel Hospital</a></li>
	          			<li><a href="#">Nepal Hospital</a></li>
	          			<li><a href="#">Kath Hospital</a></li>
	          			<hr />
					</ul>
	                <div class="accordion" id="accordion2">
	                    <div class="accordion-group">
	                        <div class="accordion-heading">
	                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
	                                Elite Hospital
	                            </a>
	                        </div>
	                        <div id="collapseOne" class="accordion-body collapse in">
	                            <div class="accordion-inner">
	                               Elite hospital are sophisticated hospitals.
	                            </div>
	                        </div>
	                    </div>
	                    <div class="accordion-group">
	                            <div class="accordion-heading">
	                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
	                                    Economical Hospital
	                                </a>
	                            </div>
	                            <div id="collapseTwo" class="accordion-body collapse">
	                                <div class="accordion-inner">
	                                   Economical hospitals are less expensive than elite. 
	                                </div>
	                            </div>
	                        </div>
	                        <div class="accordion-group">
	                        <div class="accordion-heading">
	                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
	                                Public Hospital
	                            </a>
	                        </div>
	                        <div id="collapseThree" class="accordion-body collapse in">
	                            <div class="accordion-inner">
	                              Public Hospitals Are operated by government
	                            </div>
	                        </div>
	                    </div>
	               	</div><!--/acc-->
	                 
	                  <hr>
	
	              
	                
	                </div><!--/panel body-->
	              </div><!--/panel-->
	      	</div><!--/end left column-->
      		
	      	<!--mid column-->
	      	<div class="col-md-4">
              <div class="panel" id="midCol">
                <div class="panel-heading" style="background-color:#009d00;color:#eee;">Prediction Engine</div> 
		           <div class="panel-body">
				         
								<div class="panel panel-danger">
								    <div class="panel-heading"><h2 class="text-uppercase">${disease1.diseaseName }&nbsp;<small>${disease1.probabilty } %</small></h2></div>
								    <div class="panel-body"><p>${disease1About }</div>
								</div>
								
								<div class="panel panel-warning">
								    <div class="panel-heading"><h2 class="text-uppercase">${disease2.diseaseName }&nbsp;<small>${disease2.probabilty } %</small></h2></div>
								    <div class="panel-body"><p>${disease2About }</div>
								</div>
								
								<div class="panel panel-warning">
								    <div class="panel-heading"><h2 class="text-uppercase">${disease3.diseaseName }&nbsp;<small>${disease3.probabilty } %</small></h2></div>
								    <div class="panel-body"><p>${disease3About }</div>
								</div>
								
								<div class="panel panel-warning">
								    <div class="panel-heading"><h2 class="text-uppercase">${disease4.diseaseName }&nbsp;<small>${disease4.probabilty } %</small></h2></div>
								    <div class="panel-body"><p>${disease4About }</div>
								</div>
								
								<div class="panel panel-warning">
								    <div class="panel-heading"><h2 class="text-uppercase">${disease5.diseaseName }&nbsp;<small>${disease5.probabilty } %</small></h2></div>
								    <div class="panel-body"><p>${disease5About }</div>
								</div>
							
						
								
				
							<hr />
							<h4 class="text-danger"><strong>Warning!!!: </strong> The result is just a prediction. It is strictly avoided to take medicines based on above result.
							One should only take medicine after good medical treatment from certified physician.</h4>
						
					</div>
		            
               </div><!--/panel-->
      	</div><!--/end mid column-->
      		
	      	<!-- right content column-->
	        <div class="col-md-6" id="content">
            	<div class="panel">
	    			<div class="panel-heading" style="background-color:green;color:#fff;">Top Stories</div>   
	              	<div class="panel-body">
	                  
			               <div class="row">
			                  <div class="col-md-12">
				                  <div class="well">
				                          <img src="resources/images/grande.jpg" class="img-responsive">
				                          <h3><a href="http://getbootstrap.com">Healthy habits here</a></h3>
				                          <p>
				                          Any one can be benefited from disease prediction engine. Where ever you are you can know what are you suffering from. You can also see list of hospitals and make treatment plans.
				                          </p>
				                          <p><a href="http://www.bootply.com/bootstrap-3-migration-guide" target="ext">Read about our vision.</a></p>
				                  </div>
			                  </div>
			                </div>
	                
			                  
			                <div class="row">
			                	<div class="col-md-12">
				                	<div class="well">
				                		<img src="resources/images/health-background.jpg" alt="http://www.uky.edu/" height="200px" width="100%">
						                <hr />
						                	<p>We are here to guide you through your health condition. Based on your information we will predict the most possible disease. Every time we suffer from some abnormalities we try searching in internet about possible diseases. But health guide brings all in one services. Here you can know about disease and hospitals</p>
						                  
						                 <hr />
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