package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Officer {
	private int id;
	private String firstname ;
	private String lastname ;
	private String badgeno ;
	private String idno ;
	private String contact ;
	
	public Officer() {
		
	}
	public Officer(ResultSet rs) throws SQLException, ParseException {
		
		this.id = rs.getInt(1);
		this.firstname = rs.getString(2);
		this.lastname = rs.getString(3);
		this.badgeno = rs.getString(4);
		this.idno = rs.getString(5);
		this.contact = rs.getString(6);
	
	}
	
	//setter methods
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setBadgeno(String badgeno) {
		this.badgeno = badgeno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	//getter methods for all the fields
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
     }
	public String getLastname() {
		return lastname;
	}
	public String getBadgeno() {
		return badgeno;
	}
	public String getIdno() {
		return idno;
	}
	public String  getContact() {
		return contact;
	}
	@Override
	public String toString() {
		return "ID : " +this.id+ "  Name: "  +this.firstname+ " Surname: " +this.lastname+ " Badgeno : " +this.badgeno+ " ID Number : " +this.idno+ " Contact :" +this.contact +"\n";
		
	}
	
}
