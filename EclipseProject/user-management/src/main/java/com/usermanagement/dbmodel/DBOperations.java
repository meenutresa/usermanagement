/**
 * 
 */
package com.usermanagement.dbmodel;

/**
 * @author Meenu Vincent
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.usermanagement.application.UserDetail;
public class DBOperations {

	/**
	 * Function to aacess table and insert new entry
	 */
	public boolean insertTable(String firstName, String lastName) {
		// TODO Auto-generated method stub
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.dbConnection();
		Statement stmt = null;
		String sqlstmt = "INSERT INTO persons (firstname, lastname) values(\'"+firstName+"\',\'"+lastName+"\');";
		//System.out.println(sqlstmt);
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = sqlstmt;
			stmt.executeUpdate(sql);
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return true;

	}
	//Function to read the record based on a particular id
	public UserDetail readTable(int idCondition) {
		// TODO Auto-generated method stub
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.dbConnection();
		Statement stmt = null;
		ResultSet rs = null;
		UserDetail user = new UserDetail();
		String sqlstmt = "SELECT * FROM persons where id="+idCondition+";";
		//System.out.println(sqlstmt);
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery(sqlstmt);
			while (rs.next()){
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
	            
	         }
			 rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return user;

	}
	//Function to read all the table records
	public List<UserDetail> readTable() {
		// TODO Auto-generated method stub
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.dbConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlstmt = "SELECT * FROM persons;";
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery(sqlstmt);
			
			while (rs.next()){
				UserDetail user = new UserDetail();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				userDetails.add(user);
	            	            
	         }
	         
			 rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return userDetails;

	}
	//Function to update a particular entry
	public boolean updateTable(int id, String firstName, String lastName) {
		// TODO Auto-generated method stub
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.dbConnection();
		Statement stmt = null;
		String sqlstmt = "UPDATE persons set firstname = \'"+firstName+"\' ,lastname = \'"+lastName+"\' where id = "+id+";";
		//System.out.println(sqlstmt);
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = sqlstmt;
			stmt.executeUpdate(sql);
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return true;

	}
	//Function to delete an entry
	public boolean deleteFromTable(int id) {
		// TODO Auto-generated method stub
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.dbConnection();
		Statement stmt = null;
		String sqlstmt = "DELETE FROM persons where id="+id+";";
		//System.out.println(sqlstmt);
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = sqlstmt;
			stmt.executeUpdate(sql);
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return true;

	}
	//Function to count the number of records in the table
	public int countPersonsTable() {
		// TODO Auto-generated method stub
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.dbConnection();
		Statement stmt = null;
		int count=0;
		ResultSet rs = null;
		String sqlstmt = "SELECT COUNT(*) FROM persons;";
		//System.out.println(sqlstmt);
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs= stmt.executeQuery(sqlstmt);
			while (rs.next()){
				count = rs.getInt("count");	            
	         }
			rs.close();
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return count;

	}

}
