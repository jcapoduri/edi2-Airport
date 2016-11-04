package org.edi.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.business.contract.FlightRouteDAO;
import org.edi.entities.Destiny;
import org.edi.entities.FlightRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlightRouteRepository implements FlightRouteDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public List<FlightRoute> getAll() throws Exception {
		String sql = "SELECT * FROM FlightRoutes WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<FlightRoute> result = new ArrayList<FlightRoute>();
			FlightRoute route = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				route = new FlightRoute();
				route.loadFromRecordSet(rs);
				result.add(route);
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
	public FlightRoute getById(int id) throws Exception {
		String sql = "SELECT * FROM FlightRoutes WHERE isDeleted = 0 AND id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			FlightRoute route = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				route = new FlightRoute();
				route.loadFromRecordSet(rs);
			}
			rs.close();
			ps.close();
			return route;
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
	public FlightRoute getByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightRoute> search(String needle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightRoute save(FlightRoute bean) {
		String sql = "INSERT INTO FlightRoutes (code, origin, destiny) VALUES (?, ?, ?); SELECT SCOPE_IDENTITY()";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getCode());
			ps.setInt(2, bean.getOrigin());
			ps.setInt(3, bean.getDestiny());
			FlightRoute route = null;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				route = this.getById(rs.getInt(1));
			}
			rs.close();
			ps.close();
			return route;
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
	public void update(FlightRoute bean) {
		String sql = "UPDATE FlightRoutes SET code = ?, origin = ?, destiny = ?, modificationDate = GETDATE() WHERE id = ?;";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getCode());
			ps.setInt(2, bean.getOrigin());
			ps.setInt(3, bean.getDestiny());
			ps.setInt(4, bean.getId());
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
	public void remove(FlightRoute bean) {
		String sql = "UPDATE FlightRoutes SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
		String sql = "UPDATE FlightRoutes SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
