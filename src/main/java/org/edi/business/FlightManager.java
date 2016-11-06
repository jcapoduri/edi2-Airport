package org.edi.business;

import java.util.List;

import org.edi.business.contract.IFlightManager;
import org.edi.entities.Flight;
import org.edi.io.contract.FlightDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightManager implements IFlightManager {
  @Autowired
  protected FlightDAO airlineRepository; 

  @Override
  public List<Flight> getAll() throws Exception {
    return this.airlineRepository.getAll();
  }

  @Override
  public Flight getById(int id) throws Exception {
    return this.airlineRepository.getById(id);
  }

  @Override
  public Flight getByName(String id) {
    return this.airlineRepository.getByName(id);
  }

  @Override
  public List<Flight> search(String needle) {
    return this.airlineRepository.search(needle);
  }

  @Override
  public Flight save(Flight bean) {
    return this.airlineRepository.save(bean);
  }

  @Override
  public void update(Flight bean) {
    this.airlineRepository.update(bean);

  }

  @Override
  public void remove(Flight bean) {
    this.airlineRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
    this.airlineRepository.remove(id);
  }

}
