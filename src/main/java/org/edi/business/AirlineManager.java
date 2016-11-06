package org.edi.business;

import java.util.List;

import org.edi.business.contract.IAirlineManager;
import org.edi.entities.Airline;
import org.edi.io.contract.AirlineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineManager implements IAirlineManager {
	@Autowired
	protected AirlineDAO airlineRepository;	

	@Override
	public List<Airline> getAll() throws Exception {
		return this.airlineRepository.getAll();
	}

	@Override
	public Airline getById(int id) throws Exception {
		return this.airlineRepository.getById(id);
	}

	@Override
	public Airline getByName(String id) {
		return this.airlineRepository.getByName(id);
	}

	@Override
	public List<Airline> search(String needle) {
		return this.airlineRepository.search(needle);
	}

	@Override
	public Airline save(Airline bean) {
		return this.airlineRepository.save(bean);
	}

	@Override
	public void update(Airline bean) {
		this.airlineRepository.update(bean);

	}

	@Override
	public void remove(Airline bean) {
		this.airlineRepository.remove(bean);
	}

	@Override
	public void remove(int id) {
		this.airlineRepository.remove(id);
	}

}
