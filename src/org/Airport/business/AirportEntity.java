package org.Airport.business;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

import org.Airport.io.SqlPersistableEntity;

public abstract class AirportEntity extends SqlPersistableEntity{
	protected Integer id;
	protected Timestamp    creationDate;
	protected Timestamp    modificationDate;
	protected Timestamp    deletionDate;
	protected Boolean isDeleted;
	
	public AirportEntity()  throws Exception {
		this(0);		
	}
	
	public AirportEntity(Integer id)  throws Exception {
		Date date = new Date();
		this.id = id;
		this.creationDate = new Timestamp(date.getTime());
		this.modificationDate = null;
		this.deletionDate = null;
		this.isDeleted   = false;		
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Timestamp getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Timestamp deletionDate) {
		this.deletionDate = deletionDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	abstract public void save();
	
	abstract public void erase();
	
	abstract public void get();
	
}
