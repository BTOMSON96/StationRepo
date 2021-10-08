package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;



import org.junit.jupiter.api.Test;


import controller.OfficerController;
import entity.Officer;

class OfficerControllerTest {
	int id = 7;
	int update = 14;
	int delete = 20;


	@Test
public	void TestCreateOfficer() {
		OfficerController of = new OfficerController();
		Officer officer = new Officer();
		
		officer.setName("Bunt");
		officer.setLastname("Pogba");
		officer.setBadgeno("703");
		officer.setIdno("8806074388022");
		officer.setContact("063262550");
		
		try {
			of.CreateOfficer(officer);
			assertTrue(true); //pass the test if the object is created successfully
			
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}
		
}

@Test
public void TestCreateOfficerWithNullObject() {
	OfficerController of = new OfficerController();
	Officer officer = null;
	
	try {
		of.CreateOfficer(officer);
		assertTrue(false); //fail test when object is null
		System.out.println("Officer object is null");
		
	}catch(Exception e) {
		e.printStackTrace();
		assertTrue(true); //pass if exception is caught
	}
}

	
	
@Test
public void TestReadOfficer() {
	OfficerController of = new OfficerController();

	
	try {
	of.ReadOfficer(id);
	assertTrue(true);
	}
	catch(Exception e) {
		e.printStackTrace();
		fail();
	}
}

@Test
public void TestReadWithNoArgument() {
	OfficerController of = new OfficerController();
	try {
	    of.ReadOfficer(id);
		assertTrue(false); //fail test when object is null
		System.out.println("Officer object is null");
		
	}catch(Exception e) {
		e.printStackTrace();
		assertTrue(true); //pass if exception is caught
	}
}

/**
@Test

public void TestUpdateOfficer() {
	
	OfficerController of = new OfficerController();
	Officer officer = new Officer();
	
	officer.setId(update);
	try {
	of.UpdateOfficer(officer);
	assertTrue(true);
	}catch(Exception e) {
		e.printStackTrace();
		fail();
	}
}

@Test
public void TestDeleteOfficer() {
	
	OfficerController of = new OfficerController();
	Officer officer = new Officer();
	
	officer.setId(delete);
	try {
	of.DeleteOfficer(officer);
	assertTrue(true);
	}catch(Exception e) {
		e.printStackTrace();
		fail();
	}

}


@Test

public void TestReadAll()
{
	OfficerController of = new OfficerController();
	
	Officer officer = new Officer();
	officer.getId();
	officer.getFirstname();
	officer.getLastname();
	officer.getBadgeno();
	officer.getIdno();
	officer.getContact();
	
	try {
		of.readAll();
		assertTrue(true);
	}
	catch(Exception e) {
		e.printStackTrace();
		fail();
		}
		
}
**/

}
