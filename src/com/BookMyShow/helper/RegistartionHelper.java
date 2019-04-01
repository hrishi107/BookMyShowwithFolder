package com.BookMyShow.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.BookMyShow.bean.InputRegistrationBean;
import com.BookMyShow.bean.OutputRegistrationBean;
import com.BookMyShow.dao.commonDao;




public class RegistartionHelper {

	public boolean validateFeilds(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		if(regBeanObj.getFirstName() == null && " ".equals(regBeanObj.getFirstName()))
		{
			return false;		
		}
		if(regBeanObj.getLastName() ==null && "".equals(regBeanObj.getLastName()))
		{
				return false;		
		}
		if(regBeanObj.getGender() ==null && "".equals(regBeanObj.getGender()))
		{
			return false;		
		}
		if(regBeanObj.getHobbies() ==null && "".equals(regBeanObj.getHobbies()))
		{
			return false;			
		}
		if(String.valueOf(regBeanObj.getMobileNumber())==null && "".equals(regBeanObj.getMobileNumber()))
		{
			return false;			
		}
		if(regBeanObj.getEmail()==null && "".equals(regBeanObj.getEmail()))
		{
			return false;			
		}
		if(regBeanObj.getAddress()==null && "".equals(regBeanObj.getAddress()))
		{
			return false;			
		}
		
		if(regBeanObj.getDateOfBirth()==null && "".equals(regBeanObj.getDateOfBirth()))
		{
			return false;			
		}
		if(String.valueOf(regBeanObj.getPinCode())==null && "".equals(regBeanObj.getPinCode()))
		{
			return false;			
		}
		if(regBeanObj.getPassword()==null && "".equals(regBeanObj.getPassword()))
		{
			return false;			
		}
		if(regBeanObj.getRepeatPassword()==null && "".equals(regBeanObj.getRepeatPassword()))
		{
			return false;			
		}
		else
		{
			commonDao CommDaoObj=new commonDao();
			boolean flag=CommDaoObj.insertData(regBeanObj);
			System.out.println(flag);
			return true;
		}
		
	}
	public java.sql.Date dateParsingFunction(String detail) throws ParseException
	{
		SimpleDateFormat simpleDateFormObj=new SimpleDateFormat("dd-MM-yyyy");
		Date dateObj=simpleDateFormObj.parse(detail);
		java.sql.Date lastdateObj=new java.sql.Date(dateObj.getTime()); 
		
		return lastdateObj;	
	}
	//Ajax call mobile
	public OutputRegistrationBean vlidateMobile(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
		
		if(String.valueOf(regBeanObj.getMobileNumber())==null && "".equals(regBeanObj.getMobileNumber()))
		{
			outRegBeanObj.setStatusFlag(true);
			outRegBeanObj.setStatusMessage("Ok!");
			return outRegBeanObj;
		}
		else
		{
			commonDao CommDaoObj=new commonDao();
			boolean flag=CommDaoObj.vlidateMobile(regBeanObj);
			System.out.println(flag);
			outRegBeanObj.setStatusFlag(flag);
			outRegBeanObj.setStatusMessage("Mb no already exist");;
			return outRegBeanObj;
			
		}
	}//Ajax call email
	public OutputRegistrationBean validateEmail(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
		if(regBeanObj.getEmail()==null && "".equals(regBeanObj.getEmail()))
		{
			outRegBeanObj.setStatusFlag(true);
			outRegBeanObj.setStatusMessage("Ok!");
			return outRegBeanObj;
			
		}
		else
		{
			commonDao CommDaoObj=new commonDao();
			boolean flag=CommDaoObj.vlidateEmail(regBeanObj);
			System.out.println(flag);
			outRegBeanObj.setStatusFlag(flag);
			outRegBeanObj.setStatusMessage("Email already exist");;
			return outRegBeanObj;
			
		}
		
	}
	//public InputRegistrationBean validLogin(InputRegistrationBean regBeanObj) {
		public InputRegistrationBean validLogin(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
			//InputRegistrationBean regBeanObj=new InputRegistrationBean();
			OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
			if(regBeanObj.getEmail()==null && "".equals(regBeanObj.getEmail()))
			{
				outRegBeanObj.setStatusFlag(false);
				outRegBeanObj.setStatusMessage("Ok!");
				return regBeanObj;
				
			}
			if(regBeanObj.getPassword()==null && "".equals(regBeanObj.getPassword()))
			{
				outRegBeanObj.setStatusFlag(false);
				outRegBeanObj.setStatusMessage("Ok!");
				return regBeanObj;			
			}
			else
			{
				commonDao CommDaoObj=new commonDao();
				regBeanObj=CommDaoObj.validateLogin(regBeanObj);
				outRegBeanObj.setStatusFlag(true);
				outRegBeanObj.setStatusMessage("Ok!");
				
			}
			return regBeanObj;
		}
		
	
	

	
	
}
