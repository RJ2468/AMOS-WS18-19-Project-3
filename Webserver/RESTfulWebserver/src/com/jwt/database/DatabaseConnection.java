package com.jwt.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

final class DatabaseConfig {
	@Context	
	private ServletContext context;
	
	String host;
	String database;
    String username;
    String password;

    public DatabaseConfig() { 
    	loadConfig();	
    }
    public void loadConfig() {
    	String fullPath = context.getRealPath("/WEB-INF/environement.ini");
    	Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File(fullPath)));	
		} catch(IOException ex) {
			ex.printStackTrace();
		}

		this.host = props.getProperty("POSTGRES_HOST"); 
		this.database = props.getProperty("POSTGRES_DB");
		this.username = props.getProperty("POSTGRES_USERNAME");
		this.password = props.getProperty("POSTGRES_PASSWORD");
    }
}
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private DatabaseConfig config = new DatabaseConfig();
    private String postgresURL = "jdbc:postgresql://" + config.host + ":5432/" + config.database;
    
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(postgresURL, config.username, config.password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}