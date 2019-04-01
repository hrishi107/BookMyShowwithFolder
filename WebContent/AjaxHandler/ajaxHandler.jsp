<%@page import="com.BookMyShow.helper.CommonHelper"%>
<%@page import="javax.jms.Session"%>
<%@ page import="com.BookMyShow.commonAjaxController.CommonAjaxHandler" %>
<%!long seatTbaleId=0;
long screenId=0;
long id1=0;
%>
<%!
public String Ajaxhandler(HttpServletRequest request,HttpServletResponse response)
{
	
	CommonAjaxHandler CommonajxControllerobj=new CommonAjaxHandler();
	//long seatTableId=0;
	HttpSession session=request.getSession();
	
	String action=request.getParameter("action");
	try{
		if(action!=null && !"".equals(action))
		{
			 if("checkmobNumber".equals(action))
			{
				try{
					return CommonajxControllerobj.checkMobileNum(request, response);
				}
				catch(Exception e)
				{
					
					
				}
			}
			if("checkEmail".equals(action))
			{
				try{
					return CommonajxControllerobj.checkEmail(request, response);
				}
				catch(Exception e)
				{
					
				}
			}
				
			if("checkCities".equals(action))
			{
				
				return CommonajxControllerobj.checkCities(request,response);
				
			}
			if("cityForSession".equals(action))
			{
				String cityName=request.getParameter("city");
				// HttpSession session=request.getSession();
				session.setAttribute("city", cityName);
				return cityName;		
			}
			if("checkWordsForAutoComplete".equals(action))
			{
				
				String autoComplete=request.getParameter("searchKey");
				return CommonajxControllerobj.checkWordsForAutoComplete(request,response,autoComplete);
				
			}
			if("AjaxCallForMovieDetails".equals(action))
			{
				String SearchVal=request.getParameter("searchingKey");
				return CommonajxControllerobj.AjaxCallForMovieDetails(request,response,SearchVal);	
			}
			if("checkSeatAvailability".equals(action))
			{
				
				String userId=(String)session.getAttribute("Id").toString();
				id1=Long.parseLong(userId);
				if(userId!=null && !"".equals(userId))
				{
					String selectedSeats=request.getParameter("selectedSeats");
					String id=request.getParameter("seatTableId");
					seatTbaleId=Long.parseLong(id);
					screenId=Long.parseLong(request.getParameter("screenId"));
					session.setAttribute("SelectedSeat",selectedSeats);
				return CommonajxControllerobj.BookingOfSeats(request,response,selectedSeats,seatTbaleId,screenId,id1);
				}
			}
			if("seatAlreadyBookedorNot".equals(action))
			{
				String userId=(String)session.getAttribute("Id").toString();
				id1=Long.parseLong(userId);
				//if()
				
				
			}
			
		}					
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return "";
}

%>

<%=Ajaxhandler(request,response) %>
