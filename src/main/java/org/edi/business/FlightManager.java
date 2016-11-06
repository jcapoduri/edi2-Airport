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
  protected FlightDAO flightRepository; 

  @Override
  public List<Flight> getAll() throws Exception {
    return this.flightRepository.getAll();
  }

  @Override
  public Flight getById(int id) throws Exception {
    return this.flightRepository.getById(id);
  }

  @Override
  public Flight getByName(String id) {
    return this.flightRepository.getByName(id);
  }

  @Override
  public List<Flight> search(String needle) {
    return this.flightRepository.search(needle);
  }

  @Override
  public Flight save(Flight bean) {
    return this.flightRepository.save(bean);
  }

  @Override
  public void update(Flight bean) {
    this.flightRepository.update(bean);

  }

  @Override
  public void remove(Flight bean) {
    this.flightRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
    this.flightRepository.remove(id);
  }

}
