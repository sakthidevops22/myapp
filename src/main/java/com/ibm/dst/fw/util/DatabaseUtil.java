package com.ibm.dst.fw.util;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;


public class DatabaseUtil {
	
	public static Connection getDatabaseConnection(String jdbcDSName) throws Exception{
		Context ctx=new InitialContext();  
		DataSource ds=(DataSource)ctx.lookup(jdbcDSName); 
		Connection con=ds.getConnection(); 
		return con;
	}

}
