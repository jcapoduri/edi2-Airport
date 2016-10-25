package org.edi.business.contract;


import java.util.List;
import org.edi.entities.Airport;

public interface AirportDAO {
	public Airport getById(int id)  throws Exception ;
	public Airport getByName(String id);
	public List<Airport> search(String needle);
	public void save(Airport bean);
	public void remove(Airport bean);
}
