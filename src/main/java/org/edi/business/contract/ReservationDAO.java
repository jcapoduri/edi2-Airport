package org.edi.business.contract;

import java.util.List;

import org.edi.entities.Reservation;

public interface ReservationDAO {
	public List<Reservation> getAll() throws Exception;
	public Reservation getById(int id)  throws Exception ;
	public Reservation getByName(String id);
	public List<Reservation> search(String needle);
	public Reservation save(Reservation bean);
	public void update(Reservation bean);
	public void remove(Reservation bean);
	public void remove(int id);
}
