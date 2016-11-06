package org.edi.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.entities.Passenger;
import org.edi.io.contract.PassengerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerRepository implements PassengerDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public List<Passenger> getAll() throws Exception {
		String sql = "SELECT * FROM Passengers WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Passenger> result = new ArrayList<Passenger>();
			Passenger passenger = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				passenger = new Passenger();
				passenger.loadFromRecordSet(rs);
				result.add(passenger);
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
	public Passenger getById(int id) throws Exception {
		String sql = "SELECT * FROM Passengers WHERE isDeleted = 0 AND id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Passenger passenger = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				passenger = new Passenger();
				passenger.loadFromRecordSet(rs);
			}
			rs.close();
			ps.close();
			return passenger;
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
	public Passenger getByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> search(String needle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger save(Passenger bean) {
		String sql = "INSERT INTO Passengers (name, lastname, preferedName, email, telephone, passport, document) VALUES (?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getLastname());
			ps.setString(3, bean.getPreferedName());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getTelephone());
			ps.setString(6, bean.getPassport());
			ps.setString(7, bean.getDocument());
			Passenger passenger = null;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				passenger = this.getById(rs.getInt(1));
			}
			rs.close();
			ps.close();
			return passenger;
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
	public void update(Passenger bean) {
		String sql = "UPDATE Passengers SET name = ?, lastname = ?, preferedName = ?, email = ?, telephone = ?, passport = ?, document = ?, modificationDate = GETDATE() WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getLastname());
			ps.setString(3, bean.getPreferedName());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getTelephone());
			ps.setString(6, bean.getPassport());
			ps.setString(7, bean.getDocument());
			ps.setInt(8, bean.getId());
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
	public void remove(Passenger bean) {
		String sql = "UPDATE Passengers SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
		String sql = "UPDATE Passengers SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
