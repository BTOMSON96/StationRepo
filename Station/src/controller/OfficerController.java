package controller;

import java.sql.*;
import java.util.Set;

import javax.swing.JOptionPane;

import entity.Officer;

public class OfficerController {

	
//insert data into officer table
	
	public void CreateOfficer(Officer officer) {
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
	
	}
	
	//get all records from officer table
	
	public Set<Officer> readAll(){
		Officer obj = new Officer();
		String Query = "SELECT * FROM OFFICER";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(Query);
		while(rs.next()) {
			
			
			
		   obj.setId(rs.getInt("OFFICERID"));
		   obj.setName(rs.getString("FIRSTNAME"));
		   obj.setLastname(rs.getString("LASTNAME"));
		   obj.setBadgeno(rs.getString("BADGENO"));
		   obj.setIdno(rs.getString("IDNO"));
		   obj.setContact(rs.getString("CONTACT"));
		   
		   System.out.println(obj.toString());
		}
		st.close();
		con.close();
		}
		
		
		catch (SQLException e) {
             System.out.println(e);
		}
		
		
return Set.of(obj);
	}
	
	
	
	//Retrieve data from the officer table using id
	public Officer ReadOfficer(int id) {
		Officer obj = new Officer();
		
		String Query = "SELECT * FROM OFFICER WHERE OFFICERID ="+id;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(Query);
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
	
  
	
	}
	
	//delete 
	public void DeleteOfficer(Officer officer) {
		 
	
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
		
	}
	
	
}
