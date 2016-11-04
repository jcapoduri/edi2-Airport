package org.edi.entities;

public class Reservation extends AirportEntity {
	protected int     idPassenger;
	protected int     idFlight;
	
	public Reservation() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public Reservation(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public int getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(int idPassenger) {
		this.idPassenger = idPassenger;
	}

	public int getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}

}
