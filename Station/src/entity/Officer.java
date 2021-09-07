package entity;

public class Officer {
	private int id;
	private String firstname ;
	private String lastname ;
	private String badgeno ;
	private String idno ;
	private String contact ;
	
	public Officer() {
		
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
}
