package controller;

import java.sql.*;

import javax.swing.JOptionPane;

import entity.Officer;

public class OfficerController {

	
//insert data into officer table
	public static void CreateOfficer() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    PreparedStatement ps = con.prepareStatement("INSERT INTO OFFICER(FIRSTNAME, LASTNAME, BADGENO, IDNO, CONTACT) VALUES (?,?,?,?,?)");
		    
		    ps.setString(1, "Paul");
		    ps.setString(2, "Pogba");
		    ps.setString(3, "667");
		    ps.setString(4, "9206055422055");
		    ps.setString(5, "0662526608");
		    
		    int i = ps.executeUpdate();
		    if(i > 0) {
		  JOptionPane.showMessageDialog(null, "Officer Inserted Succesfully", "MESSAGE",  i);
		    }
		   
		    con.close();
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//Retrieve data from the officer table
	public static void ReadOfficer() {
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM OFFICER");
		while(rs.next()) {
			Officer obj = new Officer();
		   obj.setId(rs.getInt("OFFICERID"));
		   obj.setName(rs.getString("FIRSTNAME"));
		   obj.setLastname(rs.getString("LASTNAME"));
		   obj.setBadgeno(rs.getString("BADGENO"));
		   obj.setIdno(rs.getString("IDNO"));
		   obj.setContact(rs.getString("CONTACT"));
		   
			System.out.println (obj.getId()+ " : " +obj.getFirstname()+ " : " +obj.getLastname()+ " : " +obj.getBadgeno()+ " : " +obj.getIdno()+ " : " +obj.getContact());
		}
		st.close();
		con.close();
		}
		
		
		catch (SQLException e) {
             System.out.println(e);
		}
	}
	//update 
	public static void UpdateOfficer() {
		Officer of = new Officer();
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

		
		
	}
	
	//delete 
	public static void DeleteOfficer() {
		 Officer id = new Officer();
		 id.setId(13);
		 String Query = " DELETE FROM OFFICER WHERE OFFICERID = "+id.getId();
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
	
	public static void main(String[] args) {
		//CreateOfficer();
		//UpdateOfficer();
		
		//DeleteOfficer();
		ReadOfficer();
	}
	
}
