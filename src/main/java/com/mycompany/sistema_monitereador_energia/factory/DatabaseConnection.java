
package com.mycompany.sistema_monitereador_energia.factory;

import com.mycompany.sistema_monitereador_energia.model.DatabaseType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    public static Connection getConnection(DatabaseType dbType) throws SQLException {
        String url;
        String user;
        String password;

        switch (dbType) {
            case MYSQL -> {
                url = "jdbc:mysql://localhost:3307/bd_monitoreo_energia";  
                user = "root";  
                password = "root"; 
            }
            case POSTGRESQL -> {
                url = "jdbc:postgresql://localhost:5432/bd_monitoreo_energia";  
                user = "postgres";  
                password = "1234";  
            }
            case TEXTFILE -> {
                return null;
            }
            default -> throw new IllegalArgumentException("Tipo de base de datos no soportado");
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a " + dbType);
            return connection;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            throw e;
        }
    }
}

