package org.edi.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.entities.Flight;
import org.edi.io.contract.FlightDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlightRepository implements FlightDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public List<Flight> getAll() throws Exception {
		String sql = "SELECT * FROM Flights WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Flight> result = new ArrayList<Flight>();
			Flight flight = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flight = new Flight();
				flight.loadFromRecordSet(rs);
				result.add(flight);
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

	@Override
	public Flight getById(int id) throws Exception {
		String sql = "SELECT * FROM Flights WHERE isDeleted = 0 AND id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Flight flight = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flight = new Flight();
				flight.loadFromRecordSet(rs);
			}
			rs.close();
			ps.close();
			return flight;
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

	@Override
	public Flight getByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> search(String needle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight save(Flight bean) {
		String sql = "INSERT INTO Flights (innerCode, idFlightRoute, idAirline, backwards) VALUES (?, ?, ?, ?); SELECT SCOPE_IDENTITY()";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getInnerCode());
			ps.setInt(2, bean.getIdFlightRoute());
			ps.setInt(3, bean.getIdAirline());
			ps.setBoolean(4,  bean.getBackwards());
			Flight flight = null;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				flight = this.getById(rs.getInt(1));
			}
			rs.close();
			ps.close();
			return flight;
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

	@Override
	public void update(Flight bean) {
		String sql = "UPDATE Flights SET innerCode = ?, idFlightRoute = ?, idAirline = ?, backwards = ?, modificationDate = GETDATE() WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getInnerCode());
			ps.setInt(2, bean.getIdFlightRoute());
			ps.setInt(3, bean.getIdAirline());
			ps.setBoolean(4,  bean.getBackwards());
			ps.setInt(5, bean.getId());
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

	@Override
	public void remove(Flight bean) {
		String sql = "UPDATE Flights SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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

	@Override
	public void remove(int id) {
		String sql = "UPDATE Flighs SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
