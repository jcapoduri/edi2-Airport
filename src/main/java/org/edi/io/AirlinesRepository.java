package org.edi.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.controllers.exceptions.AirportBasicException;
import org.edi.entities.Airline;
import org.edi.io.contract.AirlineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AirlinesRepository implements AirlineDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public List<Airline> getAll() throws Exception {
		String sql = "SELECT * FROM Airlines WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Airline> result = new ArrayList<Airline>();
			Airline airline = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				airline = new Airline();
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
	
	public Airline save(Airline bean) {
		String sql = "INSERT INTO Airlines (code, name) VALUES (?, ?); SELECT SCOPE_IDENTITY()";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getCode());
			ps.setString(2, bean.getName());
			Airline airport = null;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				airport = this.getById(rs.getInt(1));
			}
			rs.close();
			ps.close();
			return airport;
		} catch (Exception e) {
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
	
	public void update (Airline bean) {
		String sql = "UPDATE Airlines SET code = ?, name = ?, modificationDate = GETDATE() WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getCode());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getId());
			ps.executeUpdate();

			ps.close();
		} catch (Exception e) {
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
	
	public void remove(Airline bean) {
		String sql = "UPDATE Airlines SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bean.getId());
			ps.executeUpdate();

			ps.close();
		} catch (Exception e) {
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
	
	public void remove(int airlineId) {
		String sql = "UPDATE Airlines SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, airlineId);
			ps.executeUpdate();

			ps.close();
		} catch (Exception e) {
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
    
}
