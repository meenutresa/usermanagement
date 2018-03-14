package com.usermanagement.tester;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.usermanagement.application.UserManagementConsole;

public class UserManagementJunit {

	@Test
	public void testAddPerson() throws IOException {
		UserManagementConsole userManageTest = new UserManagementConsole();
		boolean resultAddPerson = userManageTest.addPerson("testfirstname","testlastname");
		assertEquals(true,resultAddPerson);
		
	}
	
	@Test
	public void testEditPerson() throws IOException {
		UserManagementConsole userManageTest = new UserManagementConsole();
		boolean resultEditPerson = userManageTest.editPerson(22,"Editfirstname","Editlastname");
		assertEquals(true,resultEditPerson);
		
	}
	
	@Test
	public void testDeletePerson() throws IOException {
		UserManagementConsole userManageTest = new UserManagementConsole();
		boolean resultDeletePerson = userManageTest.deletePerson(22);
		assertEquals(true,resultDeletePerson);
		
	}

}
