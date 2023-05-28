package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Database {
    private static final Database instance = new Database();
    private final ResourceBundle rb = ResourceBundle.getBundle("sql");
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private String getUrl() {
        return rb.getString("db.url");
    }

    private String getUsername() {
        return rb.getString("db.username");
    }

    private String getPassword() {
        return rb.getString("db.password");
    }
}
