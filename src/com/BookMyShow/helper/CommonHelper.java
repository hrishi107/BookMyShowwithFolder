package com.BookMyShow.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BookMyShow.bean.Booking;
import com.BookMyShow.dao.commonDao;

public class CommonHelper {
	
	

	public List checkCities() throws ClassNotFoundException, IOException, SQLException {
		commonDao commondaoObj=new commonDao();
		return commondaoObj.checkCities();
}

	public ArrayList<String> checkWordsForAutoComplete(HttpServletRequest request, HttpServletResponse response, String autoComplete) throws ClassNotFoundException, IOException, SQLException {
		HttpSession session=request.getSession();
		String CityName=(String)session.getAttribute("city");
		commonDao commondaoObj=new commonDao();
		ArrayList ll=commondaoObj.checkWordsForAutoComplete(CityName);
		ArrayList<String> matchedObj=new ArrayList();
		Iterator itr=ll.iterator();
		while(itr.hasNext())
		{
			String SearchKey=(String) itr.next();
			if((SearchKey.toLowerCase()).contains(autoComplete.toLowerCase()))
			{
				matchedObj.add(SearchKey);
			}
		}
		return matchedObj;	
	}
	public ArrayList<String> AjaxCallForMovieDetails(String SearchMovieValue) throws ClassNotFoundException, IOException, SQLException
	{
		commonDao commondaoObj=new commonDao();
		ArrayList ll=commondaoObj.aAjaxCallForMovieDetails(SearchMovieValue);
		return ll;
		
		
	}
	public ArrayList<String>BookingOfSeats(HttpServletRequest request, HttpServletResponse response,String selectedSeats,Long seatTableId,Long screenId, Long UserId) throws ClassNotFoundException, SQLException, IOException
	{
		//HttpSession session = request.getSession(false);
		//Long userId= Long.parseLong(session.getAttribute("Id"));
		Booking bookingObj=new Booking();
		
		ArrayList ll = new ArrayList<>();
		if(UserId!=null && !"".equals(UserId))
		{
			commonDao commondaoObj=new commonDao();
			ll=commondaoObj.BookingOfSeats(selectedSeats,seatTableId,screenId,UserId,bookingObj);
			
		}
			
		return ll;
		
		
		
	}
	public Map totalNumberOfSeatsAvailable() throws SQLException
	{
		//ArrayList ll = new ArrayList<>();
		Map totalseatmapObj=new HashMap<>();
		commonDao commondaoObj=new commonDao();
		return totalseatmapObj =commondaoObj.totalNumberOfSeatsAvailable();
		
	}
	
}
