package org.edi.business;

import java.util.List;

import org.edi.business.contract.IDestinyManager;
import org.edi.business.exception.BasicBusinessException;
import org.edi.entities.Destiny;
import org.edi.entities.FlightRoute;
import org.edi.io.contract.DestinyDAO;
import org.edi.io.contract.FlightRouteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinyManager implements IDestinyManager {
  @Autowired
  protected DestinyDAO destinyRepository; 
  
  @Autowired
  protected FlightRouteDAO flightRouteRepository; 

  @Override
  public List<Destiny> getAll() throws Exception {
    return this.destinyRepository.getAll();
  }

  @Override
  public Destiny getById(int id) throws Exception {
    return this.destinyRepository.getById(id);
  }

  @Override
  public Destiny getByName(String id) {
    return this.destinyRepository.getByName(id);
  }

  @Override
  public List<Destiny> search(String needle) {
    return this.destinyRepository.search(needle);
  }

  @Override
  public Destiny save(Destiny bean) {
    return this.destinyRepository.save(bean);
  }

  @Override
  public void update(Destiny bean) {
    this.destinyRepository.update(bean);

  }

  @Override
  public void remove(Destiny bean) {
    this.destinyRepository.remove(bean);
  }

  @Override
  public void remove(int id) throws Exception {
	List<FlightRoute> routes = flightRouteRepository.searchByDestiny(id);
	routes.addAll(flightRouteRepository.searchByOrigin(id));
	if (routes.isEmpty()) {
		this.destinyRepository.remove(id);
	} else {
		throw new BasicBusinessException("Destino actualmente en uso, no se puede borrar.");
	};
    
  }

}
