package com.jwt.controller;

import java.sql.SQLException;

import com.jwt.database.DatabaseConnection;

public class RouteController {
	DatabaseConnection dbConnection;
	
	public RouteController() {
		try {
			dbConnection = this.getConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	private DatabaseConnection getConnection() throws SQLException {
		return DatabaseConnection.getInstance();
	}
}
