package controller;
import java.sql.*;

import javax.swing.JOptionPane;

import entity.Incident;



public class IncidentController {

	//Create
	public static void CreateIncident() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    PreparedStatement ps = con.prepareStatement("INSERT INTO INCIDENT(TYPEID, SUSPECTID, CITIZENID, OFFICERID, DETAILS) VALUES (?,?,?,?,?)");
		   
		    
		    ps.setInt(1, 23 );
		    ps.setInt(2,13 );
		    ps.setInt(3, 21);
		    ps.setInt(4, 12);
		    ps.setString(5, "hhhhhhh.lhb vhh" );
		    
		    int i = ps.executeUpdate();
		    if(i > 0) {
		  JOptionPane.showMessageDialog(null, "Incident reported Succesfully", "MESSAGE",  i);
		    }
		   
		    con.close();
		} 
		catch (SQLException e) {
			System.out.println(e);
		
	}
	}
	//Read
	public static void ReadIncident() {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM INCIDENT");
			
			while(rs.next()) {
				Incident ob = new Incident();
				ob.setId(rs.getInt("INCIDENTID"));
				ob.setType(rs.getInt("TYPEID"));
				ob.setSuspect(rs.getInt("SUSPECTID"));
				ob.setCitizen(rs.getInt("CITIZENID"));
				//ob.setOfficer();
				ob.setDetails(rs.getString("DETAILS"));
				
				
				System.out.println(ob.getId()+ " : " +ob.getType()+ " : " +ob.getSuspect()+ " : " +ob.getCitizen()+ " : " +ob.getIncidentOwner()+ " : " +ob.getDetails());
			}
			st.close();
			con.close();
		}
		
		catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}
	
	//Update
	public static void UpdateIncident() {
		Incident of = new Incident();
		of.setId(25);
		
		 String Query = "UPDATE INCIDENT SET DETAILS = 'KKKDKKD HS' WHERE INCIDENTID = "+of.getId();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
		    PreparedStatement ps = con.prepareStatement(Query);
		    int i = ps.executeUpdate();
		    if(i > 0) {
		    	 JOptionPane.showMessageDialog(null, "Incident updated successfully", "MESSAGE",  i);
		    }if(i == 0) {
		    	System.out.println("No rows affected");
		    }
		    con.close();
		}
		
		catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	//Delete
	public static void DeleteIncident() {
		Incident id = new Incident();
		 id.setId(24);
		 
		 String Query = " DELETE FROM INCIDENT WHERE OFFICERID = "+id.getId();
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/station", "root", "123456");
			    PreparedStatement ps = con.prepareStatement(Query);
			    int i = ps.executeUpdate();
			    if(i > 0) {
			    	 JOptionPane.showMessageDialog(null, "Incident deleted successfully", "MESSAGE",  i);
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
