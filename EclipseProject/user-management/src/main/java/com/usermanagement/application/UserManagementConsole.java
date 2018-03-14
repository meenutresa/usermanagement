/**
 * 
 */
package com.usermanagement.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Meenu Vincent
 *
 */
import java.util.*;

import com.usermanagement.dbmodel.DBOperations;
public class UserManagementConsole {

	/**
	 * fuction which displays help
	 */
	public void helpFunction()
	{
        System.out.println( "usage" );
        System.out.println( "2 - Add Person(id, firstname, lastname)" );
        System.out.println( "3 - Edit firstname and lastname of a person with a specific id" );
        System.out.println( "4 - Delete details of a person with a specific id");
        System.out.println( "5 - Count Number of Persons" );
        System.out.println( "6 - Details of all the persons" );
	}
	
	//Function to add new person
	public boolean addPerson(String firstName, String lastName) throws IOException
	{
        DBOperations op = new DBOperations();
        return op.insertTable(firstName, lastName);
        
	}
	//Function to edit a person with id given
	public boolean editPerson(int id, String firstName, String lastName) throws IOException
	{
        DBOperations op = new DBOperations();
        return op.updateTable(id, firstName, lastName);
        
	}
	//Function to delete the erson with an id
	public boolean deletePerson(int id) throws IOException
	{
        DBOperations op = new DBOperations();
        return op.deleteFromTable(id);
        
	}
	//Function to count the number of persons
	public void countPersons()
	{
        DBOperations op = new DBOperations();
        int count = op.countPersonsTable();
        System.out.println( "Number of persons: " );
        System.out.println( count );
	}
	//Function to display all the persons
	public void listPersons()
	{
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
        DBOperations op = new DBOperations();
        UserDetail user = new UserDetail();
        String display;
        userDetails = op.readTable();
        System.out.println( "ID	First Name     	Last Name " );
        for (int i = 0; i < userDetails.size(); i++)
        {
        	user = userDetails.get(i);
        	display = user.getId()+"	"+user.getFirstName()+"		"+user.getLastName();
        	System.out.println(display);
        }
        
	}
	//Function to add from XML
	public void addFromXML() throws IOException
	{
		BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
        DBOperations op = new DBOperations();
        UserDetail user = new UserDetail();
        ReadXML rp = new ReadXML();
        System.out.println( "Enter the file name with path: " );
        String fileName = reader.readLine();
        userDetails = rp.readParseXML(fileName);
        boolean successall = true;
        boolean success = false;
        //System.out.print( "ID	First Name     	Last Name " );
        for (int i = 0; i < userDetails.size(); i++)
        {
        	user = userDetails.get(i);
        	success = op.insertTable(user.getFirstName(), user.getLastName());
        	if(!success)
        	{
        		successall = false;
        		break;
        	}
        }
        if(successall) {
        	System.out.println( "Entered all user details" );
        }
        else {
        	System.out.println( "Something went wrong" );
        }
        
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserManagementConsole userManageCon = new UserManagementConsole();
		int option;
		String exitDesicion;
		BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
    
		do
		{
		System.out.println( "Simple Command Line JAVA Application");
		System.out.println( "1. Provide Help");
        System.out.println( "2. Add Person(id, firstname, lastname)" );
        System.out.println( "3. Edit Person" );
        System.out.println( "4. Delete Person");
        System.out.println( "5. Count Number of Persons" );
        System.out.println( "6. List Persons" );
        System.out.println( "7. Add persons from XML" );
        System.out.println( "Enter the options: " );
        option = Integer.parseInt(reader.readLine()); 
        if (option == 1)
        {
        	
        	userManageCon.helpFunction();
        }
        else if(option == 2)
        {
        	System.out.println( "Enter the details" );
            System.out.println( "First Name: " );
            String firstName = reader.readLine(); 
            System.out.println( "Last Name: " );
            String lastName = reader.readLine();
        	boolean success = userManageCon.addPerson(firstName,lastName);
        	if(success) {
            	System.out.print( "Inserted user detail" );
            }
            else {
            	System.out.println( "Insertion failed" );
            }
        }
        else if(option == 3)
        {
        	System.out.println( "Enter the id of the person to edit" );
            int id = Integer.parseInt(reader.readLine());
            System.out.println( "First Name: " );
            String firstName = reader.readLine(); 
            System.out.println( "Last Name: " );
            String lastName = reader.readLine();
            boolean success = userManageCon.editPerson(id, firstName,lastName);
            if(success) {
            	System.out.println( "Edited user detail" );
            }
            else {
            	System.out.println( "Edit failed" );
            }
        }
        else if(option == 4)
        {
        	System.out.println( "Enter the id of the person to delete" );
            int id = Integer.parseInt(reader.readLine());
        	boolean success = userManageCon.deletePerson(id);
        	if(success) {
            	System.out.println( "Deleted user detail" );
            }
            else {
            	System.out.println( "Deletion failed" );
            }
        }
        else if(option == 5)
        {
        	userManageCon.countPersons();
        }
        else if(option == 6)
        {
        	userManageCon.listPersons();
        }
        else if(option == 7)
        {
        	userManageCon.addFromXML();
        }
        else {
        	System.out.print("Invalid Entry");
        }
        System.out.println( "Do you want to exit the application? Yes/No " );
        exitDesicion = reader.readLine();
         {
        	
        }
		}while(exitDesicion.equalsIgnoreCase("No"));
        //reader.close();
	}

}
