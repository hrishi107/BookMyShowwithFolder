<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green">
<%
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);	
		 if(session.getAttribute("email")==null && "".equals(session.getAttribute("email")))
		{
			 session.invalidate();
			response.sendRedirect("index.jsp");
		
		}
		 else
		 {
			 response.sendRedirect(request.getContextPath()+"/jsp/totalseat.jsp");
			 
		 }
	//session.getAttribute("email");
%>
${email} 
</h1>
<table style="color:green">


<tr><td><%=(String)request.getAttribute("firstname") %></td></tr>
<tr><td><%=(String)request.getAttribute("lastname") %></td></tr>
<tr><td><%=(String)request.getAttribute("gender") %></td></tr>
<tr><td><%=(String)request.getAttribute("Hobbies") %></td></tr>
<tr><td><%=(Long)request.getAttribute("mbnum") %></td></tr>
<tr><td><%=(String)request.getAttribute("email") %></td></tr>
<tr><td><%=(String)request.getAttribute("address") %></td></tr>

</table>
<form action="<%=request.getContextPath()%>/CommonController" method="post">
	<input type="submit" value="back to book seats">
	<input type="hidden" name="action" value="logout">
</form>


</body>
</html>