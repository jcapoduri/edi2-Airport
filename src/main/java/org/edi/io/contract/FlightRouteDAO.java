package org.edi.io.contract;

import java.util.List;

import org.edi.entities.FlightRoute;

public interface FlightRouteDAO {
	public List<FlightRoute> getAll() throws Exception;
	public FlightRoute getById(int id)  throws Exception ;
	public FlightRoute getByName(String id);
	public List<FlightRoute> search(String needle);
	public List<FlightRoute> searchByDestiny(int destinyID) throws Exception;
	public List<FlightRoute> searchByOrigin(int destinyID) throws Exception;
	public FlightRoute save(FlightRoute bean);
	public void update(FlightRoute bean);
	public void remove(FlightRoute bean);
	public void remove(int id);
}
