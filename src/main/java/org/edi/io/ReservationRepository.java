package org.edi.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.entities.Reservation;
import org.edi.io.contract.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository implements ReservationDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public List<Reservation> getAll() throws Exception {
		String sql = "SELECT * FROM Reservations WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Reservation> result = new ArrayList<Reservation>();
			Reservation reservation = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reservation = new Reservation();
				reservation.loadFromRecordSet(rs);
				result.add(reservation);
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
	public Reservation getById(int id) throws Exception {
		String sql = "SELECT * FROM Reservations WHERE isDeleted = 0 AND id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Reservation reservation = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reservation = new Reservation();
				reservation.loadFromRecordSet(rs);
			}
			rs.close();
			ps.close();
			return reservation;
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
	public Reservation getByName(String id) {
		return null;
	}

	@Override
	public List<Reservation> search(String needle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation save(Reservation bean) {
		String sql = "INSERT INTO Reservations (idPassenger, idFlight) VALUES (?, ?); SELECT SCOPE_IDENTITY()";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bean.getIdPassenger());
			ps.setInt(2, bean.getIdFlight());
			Reservation reservation = null;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				reservation = this.getById(rs.getInt(1));
			}
			rs.close();
			ps.close();
			return reservation;
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
	public void update(Reservation bean) {
		String sql = "UPDATE Reservations SET idPassenger = ?, idFlight = ?, modificationDate = GETDATE() WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bean.getIdPassenger());
			ps.setInt(2, bean.getIdFlight());
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

	@Override
	public void remove(Reservation bean) {
		String sql = "UPDATE Reservations SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
		String sql = "UPDATE Reservations SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
