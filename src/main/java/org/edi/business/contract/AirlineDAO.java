package org.edi.business.contract;


import java.util.List;
import org.edi.entities.Airline;
import org.springframework.http.ResponseEntity;

public interface AirlineDAO {
	public List<Airline> getAll() throws Exception;
	public Airline getById(int id)  throws Exception ;
	public Airline getByName(String id);
	public List<Airline> search(String needle);
	public Airline save(Airline bean);
	public void update(Airline bean);
	public void remove(Airline bean);
}
