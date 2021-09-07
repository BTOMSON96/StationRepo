package entity;

public class Incident {
	private int id;
	private int typeid;
	private int suspectid;
	private int citizenid;
	
	private Officer IncidentOwner;  // this incident object is linked to Officer object
	private String details;
	
	public Incident(){
		
	}
	
	
	//setter methods 
	 public void setId(int id) {
		 this.id = id;
		 }
	 public void setType(int typeid) {
		 this.typeid = typeid;
	 }
	public void setSuspect(int suspectid) {
		this.suspectid = suspectid;
	}
	public void setCitizen(int citizenid) {
		this.citizenid = citizenid;
	}
	public void setOfficer(Officer IncidentOwner) {
		this.IncidentOwner = IncidentOwner;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	//getter methods
		public int getId() {
			return id;
		}
		public int getType() {
			return typeid;
		}
		public int getSuspect() {
			return suspectid;
		}
		public int getCitizen() {
			return citizenid;
		}
		public Officer getIncidentOwner() {
			return IncidentOwner;
		}
		public String getDetails() {
			return details;
		}
		
}
