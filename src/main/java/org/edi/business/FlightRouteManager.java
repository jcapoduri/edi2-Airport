package org.edi.business;

import java.util.List;

import org.edi.business.contract.IFlightRouteManager;
import org.edi.entities.FlightRoute;
import org.edi.io.contract.FlightRouteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightRouteManager implements IFlightRouteManager {
  @Autowired
  protected FlightRouteDAO airlineRepository; 

  @Override
  public List<FlightRoute> getAll() throws Exception {
    return this.airlineRepository.getAll();
  }

  @Override
  public FlightRoute getById(int id) throws Exception {
    return this.airlineRepository.getById(id);
  }

  @Override
  public FlightRoute getByName(String id) {
    return this.airlineRepository.getByName(id);
  }

  @Override
  public List<FlightRoute> search(String needle) {
    return this.airlineRepository.search(needle);
  }

  @Override
  public FlightRoute save(FlightRoute bean) {
    return this.airlineRepository.save(bean);
  }

  @Override
  public void update(FlightRoute bean) {
    this.airlineRepository.update(bean);

  }

  @Override
  public void remove(FlightRoute bean) {
    this.airlineRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
    this.airlineRepository.remove(id);
  }

}
