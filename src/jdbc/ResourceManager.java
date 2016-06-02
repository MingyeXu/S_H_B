package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceManager
{
	
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/s_h_b";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "mingming";
	private static Driver driver = null;
	
	public static synchronized Connection getConnection() throws SQLException
	{
		System.out.println("getConnection");
		if(driver == null)
		{
			try 
			{
				Class<?> jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver)jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}		
			
		}
		
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	public static void close(Connection conn)
	{
		try 
		{
			if(conn != null)
			{
				conn.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}			
	}
	
	public static void close(PreparedStatement stmt)
	{
		try 
		{
			if(stmt != null)
			{
				stmt.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}			
		
	}
	
	public static void close(ResultSet rs)
	{
		try 
		{
			if(rs != null)
			{
				rs.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}			
		
	}
	

}
