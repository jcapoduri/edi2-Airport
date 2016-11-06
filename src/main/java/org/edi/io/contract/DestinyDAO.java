package org.edi.io.contract;

import java.util.List;

import org.edi.entities.Destiny;

public interface DestinyDAO {
	public List<Destiny> getAll() throws Exception;
	public Destiny getById(int id)  throws Exception ;
	public Destiny getByName(String id);
	public List<Destiny> search(String needle);
	public Destiny save(Destiny bean);
	public void update(Destiny bean);
	public void remove(Destiny bean);
	public void remove(int id);
}
