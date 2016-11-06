package org.edi.io.contract;

import org.edi.entities.AirportEntity;

public interface EntityDAO {
	public AirportEntity getById(int id);
}
