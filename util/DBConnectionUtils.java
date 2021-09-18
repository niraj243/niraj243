package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtils {

	private ConnectionParams connectionParams;

	private static DBConnectionUtils connection;

	private DBConnectionUtils() {
	}

	public static DBConnectionUtils getInstance() {
		if (connection == null) {
			connection = new DBConnectionUtils();
		}
		return connection;
	}

	public Connection getDBConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/" + connectionParams.getDbname();
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, connectionParams.getUsername(), connectionParams.getPassword());
	}

	public void setConnectionParams(ConnectionParams connectionParams) {
		this.connectionParams = connectionParams;
	}

}
