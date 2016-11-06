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
  protected FlightRouteDAO flightRouteRepository; 

  @Override
  public List<FlightRoute> getAll() throws Exception {
    return this.flightRouteRepository.getAll();
  }

  @Override
  public FlightRoute getById(int id) throws Exception {
    return this.flightRouteRepository.getById(id);
  }

  @Override
  public FlightRoute getByName(String id) {
    return this.flightRouteRepository.getByName(id);
  }

  @Override
  public List<FlightRoute> search(String needle) {
    return this.flightRouteRepository.search(needle);
  }

  @Override
  public FlightRoute save(FlightRoute bean) {
    return this.flightRouteRepository.save(bean);
  }

  @Override
  public void update(FlightRoute bean) {
    this.flightRouteRepository.update(bean);

  }

  @Override
  public void remove(FlightRoute bean) {
    this.flightRouteRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
	this.flightRouteRepository.remove(id);
  }

}
