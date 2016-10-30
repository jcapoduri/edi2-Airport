package org.edi.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class AirportEntity {
	protected Integer id;
	protected Date    creationDate;
	protected Date    modificationDate;
	protected Date    deletionDate;
	protected Boolean isDeleted;
	
	public AirportEntity()  throws Exception {
		this(0);		
	}
	
	public AirportEntity(Integer id)  throws Exception {
		
		this.id = id;
		this.creationDate = new Date(Calendar.getInstance().toInstant().getEpochSecond());
		this.modificationDate = null;
		this.deletionDate = null;
		this.isDeleted   = false;		
	}

	public Date getCreationDate() {
		return creationDate;
	}

	/*public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}*/
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
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
	
	protected List<Field> getAllFields()  throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = this.getClass();
		List<Field> fields = new ArrayList<Field>();		
		while (clazz != null) {			
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		};
		return fields;
	}
	
	public void loadFromRecordSet(ResultSet rs) throws IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException, SQLException {
		List<Field> fields = this.getAllFields();
		
		for (int i = 0; i < fields.size(); ++i)	{			
			Field field = fields.get(i);
			field.setAccessible(true);
			field.set(this, rs.getObject(field.getName()));
			/*PropertyDescriptor decriptor = new PropertyDescriptor(field.getName(), this.getClass());
			Method setMethod = decriptor.getWriteMethod();
			setMethod.invoke(this, rs.getObject(field.getName()));*/			
		};
		
	}
	
	public static String getEntityName() {
		return "relala";
	} 
	
}
