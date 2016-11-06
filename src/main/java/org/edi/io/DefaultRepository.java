package org.edi.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.entities.Airline;
import org.edi.entities.AirportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DefaultRepository<T extends AirportEntity> {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public List<T> getAll() throws Exception {
		String sql = "SELECT * FROM ? WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, T.getEntityName());
			List<T> result = new ArrayList<T>();
			T airline = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//airline = (new Class<T>()).newInstance();
				airline.loadFromRecordSet(rs);
				result.add(airline);
			}
			rs.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			System.out.println(e.toString());			
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Airline getById(int id) throws Exception {
		String sql = "SELECT * FROM Airlines WHERE isDeleted = 0 AND id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Airline airport = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				airport = new Airline();
				airport.loadFromRecordSet(rs);
			}
			rs.close();
			ps.close();
			return airport;
		} catch (SQLException e) {
			System.out.println(e.toString());			
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Airline getByName(String id) {
		try {
			return new Airline();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Airline> search(String needle) {
		return new ArrayList<Airline>();
	}
	
	public void save(Airline bean) {
		
	}
	
	public void remove(Airline bean) {
		
	}
}
