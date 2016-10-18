package org.Airport.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHandler {
	protected Connection currentConnection = null;
	protected static SqlHandler currentInstance = null;
	
	private final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	
	private static final String DB_SERVER = "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;integratedSecurity=true";
	private static final String DB_USER   = "ANNACLETA\\jcapo";
	private static final String DB_PASS   = "Kotipelto.46";
	
	static public SqlHandler instance() throws Exception {
		if (SqlHandler.currentInstance == null) {			
			SqlHandler.currentInstance = new SqlHandler();
		};
		return SqlHandler.currentInstance;
	}
	
	public PreparedStatement prepare(String query) throws SQLException {
		return this.currentConnection.prepareStatement(query);
	}
	
	public void exec() {
		//this.currentConnection.
	}
	
	protected SqlHandler() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName(driverName).newInstance();
			this.currentConnection = DriverManager.getConnection(DB_SERVER);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
