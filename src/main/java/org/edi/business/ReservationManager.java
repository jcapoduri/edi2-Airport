package org.edi.business;

import java.util.List;

import org.edi.business.contract.IReservationManager;
import org.edi.entities.Reservation;
import org.edi.io.contract.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationManager implements IReservationManager {
  @Autowired
  protected ReservationDAO rservationRepository; 

  @Override
  public List<Reservation> getAll() throws Exception {
    return this.rservationRepository.getAll();
  }

  @Override
  public Reservation getById(int id) throws Exception {
    return this.rservationRepository.getById(id);
  }

  @Override
  public Reservation getByName(String id) {
    return this.rservationRepository.getByName(id);
  }

  @Override
  public List<Reservation> search(String needle) {
    return this.rservationRepository.search(needle);
  }

  @Override
  public Reservation save(Reservation bean) {
    return this.rservationRepository.save(bean);
  }

  @Override
  public void update(Reservation bean) {
    this.rservationRepository.update(bean);

  }

  @Override
  public void remove(Reservation bean) {
    this.rservationRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
    this.rservationRepository.remove(id);
  }

}
