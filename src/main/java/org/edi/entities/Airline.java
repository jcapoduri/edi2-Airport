package org.edi.entities;

import org.edi.entities.AirportEntity;

public class Airline extends AirportEntity {
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

	public void setName(String description) {
		this.name = description;
	}

	public Airline() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public Airline(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public static String getEntityName() {
		return "Airline";
	}
}
