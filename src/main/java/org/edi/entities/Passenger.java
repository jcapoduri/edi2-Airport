package org.edi.entities;

public class Passenger extends AirportEntity {
	protected String name;
	protected String lastname;
	protected String preferedName;
	protected String document;
	protected String passport;
	protected String telephone;
	protected String email;
	
	public Passenger() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public Passenger(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPreferedName() {
		return preferedName;
	}

	public void setPreferedName(String preferedName) {
		this.preferedName = preferedName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
