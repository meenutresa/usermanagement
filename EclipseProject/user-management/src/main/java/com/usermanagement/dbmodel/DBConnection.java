/**
 * 
 */
package com.usermanagement.dbmodel;

/**
 * @author Meenu Vincent
 *
 */
import java.sql.*;
public class DBConnection {
	public Connection dbConnection() {
	final String JDBC_DRIVER = "org.postgresql.Driver";  
	final String DB_URL = "jdbc:postgresql://localhost:5432/usermanagement";
	Connection con = null;
    try {
       Class.forName(JDBC_DRIVER);
       con = DriverManager.getConnection(DB_URL,"admin", "test123");
    } 
    catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    System.out.println("Opened database successfully");
    return con;
	}
	

	/**
	 * @param args
	 */

}
