package org.Airport.io;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class SqlPersistableEntity {
	static final String createStatement = "INSERT INTO %1$s (%2$s) VALUES (%3$s)";
	static final String updateStatement = "UPDATE FROM %1$s SET %2$s WHERE id = %3$s";
	static final String deleteStatement = "UPDATE FROM %1$s SET isDeleted = 1 AND deletionDate = NOW() WHERE id = %2$s";
	static final String selectStatement = "SELECT %1$s FROM %2$s";
	
	protected SqlHandler handler;
	
	public SqlPersistableEntity() throws Exception {
		this(SqlHandler.instance());
	}
	
	public SqlPersistableEntity(SqlHandler handler) {
		this.handler = handler; 
	}
	
	public void create() throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = this.getClass();
		List<Field> fields = new ArrayList<Field>();		
		while (clazz != null) {			
			if (!clazz.getName().equals("org.Airport.io.SqlPersistableEntity"))				
				fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		};
		List<String> fieldsNames = new ArrayList<String>();
		List<String> fieldsValues = new ArrayList<String>();
		for (Field field : fields) {
			field.setAccessible(true);
			if (Modifier.isStatic(field.getModifiers())) 
				continue;
			fieldsNames.add(field.getName());
			fieldsValues.add(field.get(this).toString());
		}
		System.out.println(fieldsNames);
		System.out.println(fieldsValues);
	}
	
	protected List<Field> getAllFields()  throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = this.getClass();
		List<Field> fields = new ArrayList<Field>();		
		while (clazz != null) {			
			if (!clazz.getName().equals("org.Airport.io.SqlPersistableEntity"))				
				fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		};
		return fields;
	}
	
	protected List<String> parseAllFieldsToNames(List<Field> fields) {
		List<String> fieldsNames = new ArrayList<String>();
	
		for (Field field : fields) {
			field.setAccessible(true);
			if (Modifier.isStatic(field.getModifiers())) 
				continue;
			fieldsNames.add(field.getName());
		};
		
		return fieldsNames;
	}  
	
	public void saveNew() throws IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
		List<Field> fields = this.getAllFields();
		List<String> fieldsName = this.parseAllFieldsToNames(fields);
		String[] placeholders = new String[fieldsName.size()];
		Arrays.fill(placeholders, "?");
		
		String sqlStatement = String.format(SqlPersistableEntity.createStatement, this.entityName(), String.join(",", fieldsName), String.join(",", placeholders));
		
		try {
			PreparedStatement query = this.handler.prepare(sqlStatement);
			for (int i = 0; i < fields.size(); ++i)	{			
				Field field = fields.get(i);
				PropertyDescriptor decriptor = new PropertyDescriptor(field.getName(), this.getClass());
				Method getMethod = decriptor.getReadMethod();
				Object value = getMethod.invoke(this);
				query.setObject(i + 1, value);
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sqlStatement);
	}
	
	public void update() {
		
	}
	
	public void erase() {}
	
	public void get() {}
	
	abstract protected String entityName();
}
