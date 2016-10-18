package org.Airport.business;

public class Airport extends AirportEntity {

	public Airport() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public Airport(Integer id) throws Exception {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String entityName() {
		return "Airport";
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub

	}

	@Override
	public void get() {
		// TODO Auto-generated method stub

	}

}
