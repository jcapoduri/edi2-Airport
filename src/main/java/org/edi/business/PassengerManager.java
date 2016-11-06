package org.edi.business;

import java.util.List;

import org.edi.business.contract.IPassengerManager;
import org.edi.entities.Passenger;
import org.edi.io.contract.PassengerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerManager implements IPassengerManager {
  @Autowired
  protected PassengerDAO airlineRepository; 

  @Override
  public List<Passenger> getAll() throws Exception {
    return this.airlineRepository.getAll();
  }

  @Override
  public Passenger getById(int id) throws Exception {
    return this.airlineRepository.getById(id);
  }

  @Override
  public Passenger getByName(String id) {
    return this.airlineRepository.getByName(id);
  }

  @Override
  public List<Passenger> search(String needle) {
    return this.airlineRepository.search(needle);
  }

  @Override
  public Passenger save(Passenger bean) {
    return this.airlineRepository.save(bean);
  }

  @Override
  public void update(Passenger bean) {
    this.airlineRepository.update(bean);

  }

  @Override
  public void remove(Passenger bean) {
    this.airlineRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
    this.airlineRepository.remove(id);
  }

}
