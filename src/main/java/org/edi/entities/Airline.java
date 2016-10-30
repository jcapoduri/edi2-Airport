package org.edi.entities;

import org.edi.entities.AirportEntity;

public class Airline extends AirportEntity {
	protected String code;
	protected String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
