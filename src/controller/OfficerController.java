package controller;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.Connect;
import entity.Officer;

public class OfficerController {
	
	static Connection con = Connect.getConnection();
	
	 Statement st = null;
	 PreparedStatement ps = null;
	  ResultSet rs = null;
	
//insert data into officer table
	
	public void CreateOfficer(Officer officer) {
		try {
			
		   ps = con.prepareStatement("INSERT INTO OFFICER(FIRSTNAME, LASTNAME, BADGENO, IDNO, CONTACT) VALUES (?,?,?,?,?)");
		    
		    ps.setString(1, officer.getFirstname());
		    ps.setString(2, officer.getLastname());
		    ps.setString(3, officer.getBadgeno());
		    ps.setString(4, officer.getIdno());
		    ps.setString(5, officer.getContact());
		    
		    int i = ps.executeUpdate();
		    if(i > 0) {
		  JOptionPane.showMessageDialog(null, "Officer Inserted Succesfully", "MESSAGE",  i);
		    }
		   
		    con.close();
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println(officer.toString());
	
	}
	
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
	
	
	
	//Retrieve data from the officer table using id
	public Officer ReadOfficer(int id) {
		Officer obj = new Officer();
		
		String Query = "SELECT * FROM OFFICER WHERE OFFICERID ="+id;
		try {
			
		    st = con.createStatement();
		    rs = st.executeQuery(Query);
		while(rs.next()) {
			
			
			
		   obj.setId(rs.getInt("OFFICERID"));
		   obj.setName(rs.getString("FIRSTNAME"));
		   obj.setLastname(rs.getString("LASTNAME"));
		   obj.setBadgeno(rs.getString("BADGENO"));
		   obj.setIdno(rs.getString("IDNO"));
		   obj.setContact(rs.getString("CONTACT"));
		   
		}
		st.close();
		con.close();
		}
		
		
		catch (SQLException e) {
             System.out.println(e);
		}
		System.out.println(obj.toString());
		return obj;
	}
	
	
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
	
	
}
