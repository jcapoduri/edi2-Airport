package org.edi.business.contract;

import java.util.List;

import org.edi.entities.Passenger;

public interface IPassengerManager {
  public List<Passenger> getAll() throws Exception;
  public Passenger getById(int id)  throws Exception ;
  public Passenger getByName(String id);
  public List<Passenger> search(String needle);
  public Passenger save(Passenger bean);
  public void update(Passenger bean);
  public void remove(Passenger bean);
  public void remove(int id);
}
