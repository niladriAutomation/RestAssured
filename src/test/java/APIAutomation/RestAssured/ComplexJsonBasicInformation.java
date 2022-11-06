package APIAutomation.RestAssured;

// POJO class
public class ComplexJsonBasicInformation {
	private String firstname;
	private String lastname;
	private String designation;
	private String id;
	
	// AddressInformation class variable
	private AddressInformation address;
	
	//Setter Method to Set values and Getter Method to fetch Data
	public String getFirstname() {
		return firstname;
	}
	
	

	public AddressInformation getAddress() {
		return address;
	}



	public void setAddress(AddressInformation address) {
		this.address = address;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	
	

}
