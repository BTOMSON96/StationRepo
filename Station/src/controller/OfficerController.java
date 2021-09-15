package controller;

import java.sql.*;


import javax.swing.JOptionPane;

import entity.Officer;

public class OfficerController {

	
//insert data into officer table
	public Officer CreateOfficer(Officer officer) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    PreparedStatement ps = con.prepareStatement("INSERT INTO OFFICER(FIRSTNAME, LASTNAME, BADGENO, IDNO, CONTACT) VALUES (?,?,?,?,?)");
		    
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
		return officer;
	}
	
	//Retrieve data from the officer table
	public Officer ReadOfficer(Officer obj) {
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM OFFICER");
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
	public Officer UpdateOfficer(Officer of) {
		
		of.setId(13);
		
		 String Query = "UPDATE OFFICER SET BADGENO = 458 WHERE OFFICERID = "+of.getId();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    PreparedStatement ps = con.prepareStatement(Query);
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
	
  return of;
	
	}
	
	//delete 
	public Officer DeleteOfficer(Officer officer) {
		 
		 officer.setId(13);
		 String Query = " DELETE FROM OFFICER WHERE OFFICERID = "+officer.getId();
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
			    PreparedStatement ps = con.prepareStatement(Query);
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
			return officer;
	}
	
	
}
