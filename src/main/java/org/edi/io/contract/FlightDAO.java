package org.edi.io.contract;

import java.util.List;

import org.edi.entities.Flight;

public interface FlightDAO {
	public List<Flight> getAll() throws Exception;
	public Flight getById(int id)  throws Exception ;
	public Flight getByName(String id);
	public List<Flight> search(String needle);
	public Flight save(Flight bean);
	public void update(Flight bean);
	public void remove(Flight bean);
	public void remove(int id);
}
