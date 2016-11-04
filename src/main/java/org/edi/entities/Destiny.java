package org.edi.entities;

public class Destiny extends AirportEntity {
	protected String code;
	protected String name;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Destiny() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public Destiny(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}
}
