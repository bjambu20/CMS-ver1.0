package databaseconnection;


import java.sql.*;

public class databasecon
{
	static Connection con;
	public static Connection getconnection()
	{
 		
 			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
//			con = DriverManager.getConnection("jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/camcloud","log","log");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
		}
		catch(Exception e)
		{
			System.out.println("class error");
		}
		return con;
	}
	
}
