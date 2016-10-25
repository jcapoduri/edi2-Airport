package org.edi.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.business.contract.AirportDAO;
import org.edi.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AirportRepository implements AirportDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public Airport getById(int id) throws Exception {
		String sql = "SELECT * FROM Airport WHERE id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Airport airport = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				airport = new Airport();
				airport.setId(rs.getInt("id"));
			}
			rs.close();
			ps.close();
			return airport;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Airport getByName(String id) {
		try {
			return new Airport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Airport> search(String needle) {
		return new ArrayList<Airport>();
	}
	
	public void save(Airport bean) {
		
	}
	
	public void remove(Airport bean) {
		
	}
    
}
