package com.mycompany.sistema_monitereador_energia.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
     private static final String URL = "jdbc:postgresql://localhost:5432/bd_monitoreo_energia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private static DatabaseConnection instance; //Patron Singleton
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new SQLException("Error al conectar a la base de datos: " + ex.getMessage());
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
