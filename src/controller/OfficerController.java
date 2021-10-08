package controller;

//import java.sql.*;
//import java.util.ArrayList;

//import javax.swing.JOptionPane;

//import connection.Connect;
import entity.Officer;
import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.boot.*;


public class OfficerController {
	
	//static Connection con = Connect.getConnection();
	
	// Statement st = null;
	// PreparedStatement ps = null;
	  //ResultSet rs = null;
	
//insert data into officer table
	
	public void CreateOfficer(Officer officer) {
		
		    
		   
		    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		    
		    Metadata mtd = new MetadataSources(ssr).getMetadataBuilder().build();
		   
		   SessionFactory sf = mtd.getSessionFactoryBuilder().build();
		   
		   Session session = sf.openSession();
		   Transaction trans = session.beginTransaction();

			
		    officer.getFirstname();
		    officer.getLastname();
		    officer.getBadgeno();
		    officer.getIdno();
		    officer.getContact();
		   
		   session.save(officer);
		   
		   trans.commit();
		   System.out.println("Saved Succesfully");
		   sf.close();
		   session.close();
		   
		    
		 
		System.out.println(officer.toString());
	
	}
	
	/**
	
	//get all records from officer table
	
	public ArrayList<Officer> readAll() throws  Exception{
		
		ArrayList<Officer>  officerList = new ArrayList<>();
	
			
		   st = con.createStatement();
		   String Query = "SELECT * FROM OFFICER";
		  rs = st.executeQuery(Query);
		while(rs.next()) {
			
			Officer officer = new Officer(rs);
			officerList.add(officer);
			
			
		}
		System.out.println(officerList.toString());
return officerList;
	}
	**/
	
	
	//Retrieve data from the officer table using id
	public Officer ReadOfficer(int id) {
		Officer officer = new Officer();
			   
		    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		    
		    Metadata mtd = new MetadataSources(ssr).getMetadataBuilder().build();
		   
		   SessionFactory sf = mtd.getSessionFactoryBuilder().build();
		   
		   Session session = sf.openSession();
		   Transaction trans = session.beginTransaction();

			officer = (Officer)session.get(Officer.class, id);
		   
		   trans.commit();
		   
		   sf.close();
		   session.close();
		   
		    
		 
		System.out.println(officer.toString());
		return officer;
	}
	
	/**
	
	//update 
	public void UpdateOfficer(Officer of) {
		
		
		 String Query = "UPDATE OFFICER SET BADGENO = 458 WHERE OFFICERID = "+of.getId();
		try {
			
		     ps = con.prepareStatement(Query);
		    int i = ps.executeUpdate();
		    if(i > 0) {
		    	 JOptionPane.showMessageDialog(null, "Officer updated successfully", "MESSAGE",  i);
		    }if(i == 0) {
		    	System.out.println("No rows affected");
		    }
		    con.close();
		}
		
		catch (SQLException e) {
			System.out.println(e);
		}
	
  
	
	}
	
	//delete 
	public void DeleteOfficer(Officer officer) {
		 
	
		 String Query = " DELETE FROM OFFICER WHERE OFFICERID = "+officer.getId();
			try {
				
			     ps = con.prepareStatement(Query);
			    int i = ps.executeUpdate();
			    if(i > 0) {
			    	 JOptionPane.showMessageDialog(null, "Officer deleted successfully", "MESSAGE",  i);
			    }if(i == 0) {
			    	System.out.println("No rows affected");
			    }
			    con.close();
			}
			
			catch (SQLException e) {
				System.out.println(e);
			} 
		
	}
	**/
	
}
