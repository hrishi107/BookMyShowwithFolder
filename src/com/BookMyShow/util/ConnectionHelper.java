package com.BookMyShow.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.ServletDemo.util.ConnectionHelper;

public class ConnectionHelper {

	static Connection c=null;
	public static Connection getconnection() throws ClassNotFoundException, IOException, SQLException {
		
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties p=new Properties();
			//InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("Prop.properties");
			InputStream is=ConnectionHelper.class.getClassLoader().getResourceAsStream("com/BookMyShow/util/Prop.properties");
			p.load(is);
			Connection c=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
			 return c;
			
		} catch (Exception e) 
		{
			
		}
			return c;
		
	    
		
	}
	public static Connection ReleaseConnection() throws SQLException
	{
		c.close();
		return c;
		
	}

	
	
}
