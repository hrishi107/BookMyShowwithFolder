package com.BookMyShow.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BookMyShow.bean.Booking;
import com.BookMyShow.bean.InputLoginBean;
import com.BookMyShow.bean.InputRegistrationBean;
import com.BookMyShow.helper.RegistartionHelper;
import com.BookMyShow.util.ConnectionHelper;

public class commonDao {
	//ArrayList<String> al=new ArrayList<>();
	public ArrayList<String> aAjaxCallForMovieDetails(String searchMovieValue) throws ClassNotFoundException, IOException, SQLException {
		
		ConnectionHelper conhelperObj=new  ConnectionHelper();
		Connection con=conhelperObj.getconnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		ArrayList<String> al=new ArrayList<>();
		try{
			if(!con.isClosed())
			{
				String searchQuery ="SELECT m.title,m.cast,m.crew,m.type,t.theatername,tt.screen,tt.time FROM movie m inner join theaterscreen tt on m.pkmovieid=tt.fktheaterscreen_movieid left join theater t on t.pktheaterid=tt.fktheaterscreen_theaterid  WHERE m.title='"+searchMovieValue+"'";

				ps=con.prepareStatement(searchQuery);
				rs = ps.executeQuery();
				while(rs.next())
				{
					al.add(rs.getString(1));
					al.add(rs.getString(2));
					al.add(rs.getString(3));
					al.add(rs.getString(4));
					al.add(rs.getString(5));
					al.add(rs.getString(6));
					al.add(rs.getString(7));
					
	        	 
					}
				System.out.println(al);
	        return al;
			}
		}catch(Exception e){e.printStackTrace();}
		finally{
			con.close();
		}
				return al;

	}
	public ArrayList<String> BookingOfSeats(String selectedSeats,Long seatTableId,Long screenId,Long UserId, Booking bookingObj) throws SQLException, ClassNotFoundException, IOException
	{
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con=ConnectionHelper.getconnection();
		ArrayList<String> al=new ArrayList<>();
		PreparedStatement ps=null;
		try 
		{		 
		//,created_date,created_by
			if(!con.isClosed())
			{
				java.util.Date dt = new java.util.Date();

				java.text.SimpleDateFormat sdf = 
				 new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String currentTime = sdf.format(dt);
				
				bookingObj.setFkbooking_seatstableid(seatTableId);
				bookingObj.setFkbooking_theaterscreenid(screenId);
				bookingObj.setFkbooking_userinfoid(UserId);
				bookingObj.setSeatnumber(selectedSeats);
				
				
				
				
				String sql="insert into booking (fkbooking_seatstableid,fkbooking_theaterscreenid,fkbooking_userinfoid,seatnumber,bookingdate,created_date,created_by) values(?,?,?,?,?,?)";
				ps=con.prepareStatement(sql);
				
				ps.setLong(1,bookingObj.getFkbooking_seatstableid());
				ps.setLong(2,bookingObj.getFkbooking_theaterscreenid());
				ps.setLong(3, bookingObj.getFkbooking_userinfoid());
				ps.setString(4,bookingObj.getSeatnumber());
				ps.setString(5,currentTime);
				ps.setString(6, currentTime);
				//ps.setString(6, currentTime);
				ps.setLong(7, 1001);
				ps.executeUpdate();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			con.close();
			
		}
		return al;
		
		//return true;

		
	}
	
	public ArrayList<String> checkCities() throws ClassNotFoundException, IOException, SQLException {
		ConnectionHelper conhelperObj=new  ConnectionHelper();
		Connection con=conhelperObj.getconnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		ArrayList<String> al=new ArrayList<>();
		try{
			if(!con.isClosed())
			{
				String searchQuery ="select distinct city from citymaster";
				ps=con.prepareStatement(searchQuery);
				rs = ps.executeQuery();
				while(rs.next())
				{
					al.add(rs.getString(1));
	        	 
					}
	        // return al;
			}
		}catch(Exception e){e.printStackTrace();}
		finally{
			con.close();
		}
				return al;
	}//AutoComplete
	public ArrayList<String> checkWordsForAutoComplete(String cityName) throws ClassNotFoundException, IOException, SQLException {
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con=ConnectionHelper.getconnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		ArrayList<String> al=new ArrayList<>();
		

		try
		{
			if(!con.isClosed()){
				if(con!=null){
					String searchQuery ="SELECT m.title,t.theatername FROM movie m inner join theaterscreen tt on m.pkmovieid=tt.fktheaterscreen_movieid inner join theater t on t.pktheaterid=tt.fktheaterscreen_theaterid inner join citymaster c on c.pkcityid=t.fktheater_cityid WHERE c.city='"+cityName+"'";

					ps=con.prepareStatement(searchQuery);
					rs = ps.executeQuery();
					while(rs.next())
					{
						al.add(rs.getString(1));
						al.add(rs.getString(2)+" "+cityName);
	        	 
					}
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}
		return al;
	}

	public boolean insertData(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con=ConnectionHelper.getconnection();
		
		PreparedStatement ps=null;
		try 
		{		 
		//,created_date,created_by
			if(!con.isClosed())
			{
				java.util.Date dt = new java.util.Date();

				java.text.SimpleDateFormat sdf = 
				 new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String currentTime = sdf.format(dt);

				System.out.println("Connection is On");
				String sql="insert into userinfo (firstname,lastname,gender,hobbies,mobileno,email,address,dateOfBirth,pincode,password,repeatpassword,created_date,created_by) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setString(1,regBeanObj.getFirstName());
				ps.setString(2,regBeanObj.getLastName());
				ps.setString(3,regBeanObj.getGender());
				ps.setString(4,regBeanObj.getHobbies());
				ps.setLong(5,regBeanObj.getMobileNumber());
				ps.setString(6,regBeanObj.getEmail());
				ps.setString(7,regBeanObj.getAddress());
				java.sql.Date lastdateObj=new RegistartionHelper().dateParsingFunction(regBeanObj.getDateOfBirth());
				ps.setDate(8,lastdateObj);
				ps.setLong(9,regBeanObj.getPinCode());
				ps.setString(10,regBeanObj.getPassword());
				ps.setString(11,regBeanObj.getRepeatPassword());
				ps.setString(12,currentTime);	
				ps.setLong(13,1001);
				int value=ps.executeUpdate();
				System.out.println(value);
				
				if(value>0)
				{
					
					return true;
					
				}
				else
				{
					return false;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			con.close();
			
		}
		
		return true;
		
		
	}

	public InputRegistrationBean validateLogin(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con=ConnectionHelper.getconnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		 
		boolean flag=false;
		
		try{
			if(!con.isClosed())
			{
		         String searchQuery ="select userid, firstname,lastname,gender,hobbies,mobileno,email,address from userinfo where email=? and password=?";
		         ps=con.prepareStatement(searchQuery);
		         ps.setString(1,regBeanObj.getEmail());
		         ps.setString(2,regBeanObj.getPassword());
		        
		         rs = ps.executeQuery();
		         while(rs.next())
		         {
		        	 regBeanObj.setId(rs.getLong(1));
		        	 regBeanObj.setFirstName(rs.getString(2));
		        	 regBeanObj.setLastName(rs.getString(3));
		        	 regBeanObj.setGender(rs.getString(4));
		        	 regBeanObj.setHobbies(rs.getString(5));
		        	 regBeanObj.setMobileNumber(rs.getLong(6));
		        	 regBeanObj.setEmail(rs.getString(7));
		        	 regBeanObj.setAddress(rs.getString(8));
		        	 
		        	 System.out.println(regBeanObj);
		      }
		    
		    }
		}
			catch(Exception e)
		    {
		    	  e.printStackTrace();
		    }
			finally
			{
				con.close();
			
			}
		return regBeanObj;

	}
	public boolean vlidateMobile(InputRegistrationBean regBeanObj) throws SQLException, ClassNotFoundException, IOException {
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con=ConnectionHelper.getconnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		try 
		{
			if(!con.isClosed())
			{
		         String searchQuery ="select * from userinfo where mobileno=?";
		         ps=con.prepareStatement(searchQuery);
		         ps.setLong(1,regBeanObj.getMobileNumber());
		         rs=ps.executeQuery();
		         return !rs.first();
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
			//System.out.println("Login failed..!");
		}
		finally
		{
			con.close();
		}
		return true;
		


	}

	public boolean vlidateEmail(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con=ConnectionHelper.getconnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		try 
		{
			if(!con.isClosed())
			{
		         String searchQuery ="select * from userinfo where email=?";
		         ps=con.prepareStatement(searchQuery);
		         ps.setString(1,regBeanObj.getEmail());
		         rs=ps.executeQuery();
		         return !rs.first();
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
			//System.out.println("Login failed..!");
		}
		finally
		{
			con.close();
		}
		return true;
		
	}
	public Map totalNumberOfSeatsAvailable() throws SQLException 
	{
		ConnectionHelper conHelperObj=new ConnectionHelper(); 
		Connection con = null;
		try {
			con = ConnectionHelper.getconnection();
		} catch (ClassNotFoundException | IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs=null;
		//ArrayList al=new ArrayList();
		Map totalseatmapObj=new HashMap<>(); 
		PreparedStatement ps=null;
		try 
		{
			if(!con.isClosed())
			{
		         String searchQuery ="SELECT m.pkmovieid, m.title,t.pktheaterid,t.theatername,tt.screen,tt.pktheaterscreenid,tt.time,sss.pkseattypeid,sss.seattype,ss.totalseats,ss.pkseatsid FROM movie m inner join theaterscreen tt on m.pkmovieid=tt.fktheaterscreen_movieid left join theater t on t.pktheaterid=tt.fktheaterscreen_theaterid inner join seatstable ss on t.pktheaterid=ss.fkseats_theaterid right join seattype sss on sss.pkseattypeid=ss.fkseats_seattypeid  WHERE m.title='Manikarnika' and  t.theatername='citypride'";
		         ps=con.prepareStatement(searchQuery);
		         Map totalSeatItteration =new HashMap<>();
		         rs = ps.executeQuery();
					while(rs.next())
					{
						/*al.add(rs.getString(1));
						al.add(rs.getInt(2)); 
						al.add(rs.getInt(3));
						al.add(rs.getInt(4));
	        	 */		totalseatmapObj.put("PkMovieId",rs.getString(1));
						totalseatmapObj.put("Movie",rs.getString(2));
						totalseatmapObj.put("PkTheaterId", rs.getString(3));
						totalseatmapObj.put("Theater", rs.getString(4));
						totalseatmapObj.put("screen", rs.getString(5));
						totalseatmapObj.put("PkscreenId", rs.getString(6));
						totalseatmapObj.put("time", rs.getString(7));
						totalseatmapObj.put("pkseattypeId", rs.getString(8));
						totalseatmapObj.put(rs.getString(9), rs.getInt(10));
						totalseatmapObj.put("pkseattableId", rs.getString(11));
						
						
					}

			}
			
		}
		catch (Exception e){
			e.printStackTrace();
			//System.out.println("Login failed..!");
		}
		finally
		{
			con.close();
		}
		return totalseatmapObj;		
	}
	

}
