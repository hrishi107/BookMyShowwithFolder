<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="./css/bookmyshow.css">	 -->
<!-- <script type="text/javascript" src="./javascript/jquery-3.3.1.js"></script> -->
 <!--  <link href="./css/jquery-ui.css" rel="Stylesheet"></link> -->
<!-- <script src="YourJquery source path"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script> -->
<link rel="stylesheet" href="./css/bookmyshow.css">
<link href="./css/jquery-ui.css" rel="Stylesheet"></link>
  <script type="text/javascript" src="./javascript/jquery-3.3.1.js"></script>
 <script src="./javascript/jquery-ui.js" ></script>
  <script type="text/javascript" src="./javascript/Regjquery.js"></script> 
																					
</head>
<body>

<header class="Header">
			<div class="primaryheader">
				
					<div class="">
					<!-- <form action=""> -->
					<span class="bookmyshowpng"></span>
					<input id="Serching" onkeyup="demo.autoCompleteFunction()" class="searchboxheader" type="text" placeholder="Search for Movies, Events, Plays, Sports and Activities" spellcheck="false" background-color: transparent;">
					<input type="hidden" name="action" value="Search">
					</div>
					<!-- </form> -->
				<div class="innernav">
					<ul id="citydiv" class="headerlinks">
						<li class="swing">
						<a href="/movies" class="nav-link">Movies</a>
						</li>
						<li class="swing">
						<a href="/movies" class="nav-link">Events</a>
						</li>
						<li class="swing">
						<a href="/movies" class="nav-link">plays</a>
						</li>
						<li class="swing">
						<%session.getAttribute("email");
						
						
						
						%>
						<a id="login" onclick="demo.loginPopUp()" class="nav-link">Login</a>
						</li>
						<li class="swing">
						<a id="register" onclick="demo.popUp()" class="nav-link">Register</a>
						</li>
						<li  id="CurrentCity" class="swing">
							
						</li>
						
						<div class="clr"></div>
					</ul>
					
				
					</div>
					
					 
		</div><!--primary heder-->
				
				
				
	</header><!-- main header -->


</body>
</html>