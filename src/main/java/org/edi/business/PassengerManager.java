package org.edi.business;

import java.util.List;

import org.edi.business.contract.IPassengerManager;
import org.edi.entities.Passenger;
import org.edi.io.contract.PassengerDAO;
import org.edi.io.contract.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerManager implements IPassengerManager {
  @Autowired
  protected PassengerDAO passengerRepository; 
  
  @Autowired
  protected ReservationDAO reservationRepository; 

  @Override
  public List<Passenger> getAll() throws Exception {
    return this.passengerRepository.getAll();
  }

  @Override
  public Passenger getById(int id) throws Exception {
    return this.passengerRepository.getById(id);
  }

  @Override
  public Passenger getByName(String id) {
    return this.passengerRepository.getByName(id);
  }

  @Override
  public List<Passenger> search(String needle) {
    return this.passengerRepository.search(needle);
  }

  @Override
  public Passenger save(Passenger bean) {
    return this.passengerRepository.save(bean);
  }

  @Override
  public void update(Passenger bean) {
    this.passengerRepository.update(bean);

  }

  @Override
  public void remove(Passenger bean) {
    this.passengerRepository.remove(bean);
  }

  @Override
  public void remove(int id) {	  
    this.passengerRepository.remove(id);
  }

}
