package org.edi.entities;

public class Flight extends AirportEntity {
	protected String  innerCode;
	protected int     idFlightRoute;
	protected int     idAirline;
	protected Boolean backwards;
	
	public Flight() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public Flight(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}

	public int getIdFlightRoute() {
		return idFlightRoute;
	}

	public void setIdFlightRoute(int idFlightRoute) {
		this.idFlightRoute = idFlightRoute;
	}

	public int getIdAirline() {
		return idAirline;
	}

	public void setIdAirline(int idAirline) {
		this.idAirline = idAirline;
	}

	public Boolean getBackwards() {
		return backwards;
	}

	public void setBackwards(Boolean backwards) {
		this.backwards = backwards;
	}	
}
