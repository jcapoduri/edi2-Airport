package org.edi.entities;

public class FlightRoute extends AirportEntity {
	protected String code;
	protected int    origin;
	protected int    destiny;
	
	public FlightRoute() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public FlightRoute(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getDestiny() {
		return destiny;
	}

	public void setDestiny(int destiny) {
		this.destiny = destiny;
	}
	
	
}
