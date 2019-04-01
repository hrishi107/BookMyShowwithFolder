package com.BookMyShow.commonAjaxController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BookMyShow.bean.InputRegistrationBean;
import com.BookMyShow.bean.OutputRegistrationBean;
import com.BookMyShow.helper.CommonHelper;
import com.BookMyShow.helper.RegistartionHelper;
//import com.ServletDemo.bean.InputRegistrationBean;
//import com.ServletDemo.bean.OutputRegistrationBean;
//import com.ServletDemo.helper.RegistartionHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonAjaxHandler {

	
	public String toJSON(Object jsonObject)
	{
		Gson gson= new GsonBuilder().create();
		return gson.toJson(jsonObject);
	}
	
	public String checkMobileNum(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException
	{
		InputRegistrationBean regBeanObj=new InputRegistrationBean();
		regBeanObj.setMobileNumber(Long.parseLong(request.getParameter("mobile")));
		
		RegistartionHelper reghelperObj=new RegistartionHelper();
		
		OutputRegistrationBean flag = reghelperObj.vlidateMobile(regBeanObj);
		return toJSON(flag);
	}
	public String checkEmail(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException
	{
		InputRegistrationBean regBeanObj=new InputRegistrationBean();
		regBeanObj.setEmail(request.getParameter("email"));
		
		RegistartionHelper reghelperObj=new RegistartionHelper();
		OutputRegistrationBean flag = reghelperObj.validateEmail(regBeanObj);
		return toJSON(flag);
		
		
		
		
	}
	public String checkCities(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException
	{ 
		boolean flag=false;
		
		CommonHelper commonhelperobj=new CommonHelper();
		List ll = commonhelperobj.checkCities();
		return toJSON(ll);
	}
	public String checkWordsForAutoComplete(HttpServletRequest request,HttpServletResponse response,String autoComplete) throws ClassNotFoundException, IOException, SQLException
	{
		//String autoComplete1=request.getParameter("autoCompletVar");
		//System.out.println(autoComplete1);
		CommonHelper commonhelperobj=new CommonHelper();
		List ll=commonhelperobj.checkWordsForAutoComplete(request,response,autoComplete);
		return toJSON(ll);
		
			
	}
	public String AjaxCallForMovieDetails(HttpServletRequest request,HttpServletResponse response,String SearchMovieValue) throws ClassNotFoundException, IOException, SQLException
	{
		CommonHelper commonhelperobj=new CommonHelper();
		List ll=commonhelperobj.AjaxCallForMovieDetails(SearchMovieValue);
		return toJSON(ll);
		
		//return null;
	}		
		
	public String BookingOfSeats(HttpServletRequest request,HttpServletResponse response,String selectedSeats,long seatTableId,long screenId,long UserId) throws ClassNotFoundException, SQLException, IOException
	{
		CommonHelper commonhelperobj=new CommonHelper();
		List ll=commonhelperobj.BookingOfSeats(request,response,selectedSeats,seatTableId,screenId,UserId);
		return toJSON(ll);
		
	}
	public Map totalNumberOfSeatsAvailable(HttpServletRequest request,HttpServletResponse response)
	{
		CommonHelper commonhelperobj=new CommonHelper();
		//ArrayList ll =new ArrayList();
		Map totalseatmapObj=null;
		try {
			totalseatmapObj = commonhelperobj.totalNumberOfSeatsAvailable();
			request.setAttribute("ListOfDetails",totalseatmapObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalseatmapObj;
		
	}
}
