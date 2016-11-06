package org.edi.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.edi.entities.Destiny;
import org.edi.io.contract.DestinyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DestinyRepository implements DestinyDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public List<Destiny> getAll() throws Exception {
		String sql = "SELECT * FROM Destinies WHERE isDeleted = 0";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Destiny> result = new ArrayList<Destiny>();
			Destiny destiny = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				destiny = new Destiny();
				destiny.loadFromRecordSet(rs);
				result.add(destiny);
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
	public Destiny getById(int id) throws Exception {
		String sql = "SELECT * FROM Destinies WHERE isDeleted = 0 AND id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Destiny destiny = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				destiny = new Destiny();
				destiny.loadFromRecordSet(rs);
			}
			rs.close();
			ps.close();
			return destiny;
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
	public Destiny getByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destiny> search(String needle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destiny save(Destiny bean) {
		String sql = "INSERT INTO Destinies (code, name) VALUES (?, ?); SELECT SCOPE_IDENTITY()";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getCode());
			ps.setString(2, bean.getName());
			Destiny destiny = null;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				destiny = this.getById(rs.getInt(1));
			}
			rs.close();
			ps.close();
			return destiny;
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
	public void update(Destiny bean) {
		String sql = "UPDATE Destinies SET code = ?, name = ?, modificationDate = GETDATE() WHERE id = ?;";
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

	@Override
	public void remove(Destiny bean) {
		String sql = "UPDATE Destinies SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
		String sql = "UPDATE Destinies SET deletionDate = GETDATE(), isDeleted = 1 WHERE id = ?;";
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
