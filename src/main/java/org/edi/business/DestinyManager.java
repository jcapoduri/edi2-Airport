package org.edi.business;

import java.util.List;

import org.edi.business.contract.IDestinyManager;
import org.edi.entities.Destiny;
import org.edi.io.contract.DestinyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinyManager implements IDestinyManager {
  @Autowired
  protected DestinyDAO airlineRepository; 

  @Override
  public List<Destiny> getAll() throws Exception {
    return this.airlineRepository.getAll();
  }

  @Override
  public Destiny getById(int id) throws Exception {
    return this.airlineRepository.getById(id);
  }

  @Override
  public Destiny getByName(String id) {
    return this.airlineRepository.getByName(id);
  }

  @Override
  public List<Destiny> search(String needle) {
    return this.airlineRepository.search(needle);
  }

  @Override
  public Destiny save(Destiny bean) {
    return this.airlineRepository.save(bean);
  }

  @Override
  public void update(Destiny bean) {
    this.airlineRepository.update(bean);

  }

  @Override
  public void remove(Destiny bean) {
    this.airlineRepository.remove(bean);
  }

  @Override
  public void remove(int id) {
    this.airlineRepository.remove(id);
  }

}
