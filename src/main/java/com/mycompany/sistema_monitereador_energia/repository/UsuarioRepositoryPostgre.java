
package com.mycompany.sistema_monitereador_energia.repository;

import com.mycompany.sistema_monitereador_energia.util.DatabaseConnection;
import com.mycompany.sistema_monitereador_energia.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuarioRepositoryPostgre implements UsuarioRepository{
    private Connection connection;

    public UsuarioRepositoryPostgre() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuarios(nombre, contrasena) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2,usuario.getContrasena());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario(int id) {
         String query = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getNString("nombre"), rs.getString("contrasena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> empleados = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                empleados.add(new Usuario(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("contrasena"))); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public void eliminarUsuario(int id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuarios SET nombre = ?, contrasena = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getContrasena());
            pstmt.setInt(3, usuario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuarioNombre(String nombre) {
        String query = "SELECT * FROM usuarios WHERE nombre = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, nombre);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("contrasena"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
    
    
    
}
