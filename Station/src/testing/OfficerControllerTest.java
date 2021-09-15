package testing;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import controller.OfficerController;
import entity.Officer;

class OfficerControllerTest {

	//Officer officer = null;
	//OfficerController of = null;
	
	@Before
	public void setUp() {
		

	}
	
	
	@Test
public	void TestCreateOfficer() {
		Officer officer = new Officer();
		
		officer.setName("Bunt");
		officer.setLastname("Tom");
		officer.setBadgeno("1823");
		officer.setIdno("8806044288022");
		officer.setContact("0782625508");
		
		OfficerController of = new OfficerController();
		Assertions.assertEquals(officer, of.CreateOfficer(officer) );
		
		
	}
	@Test
	public void TestReadOfficer() {
		
		
		
		
		
	}
	@Test
	public void TestUpdateOfficer() {
		
	}
	@Test
	public void TestDeleteOfficer() {
		
	}

}
