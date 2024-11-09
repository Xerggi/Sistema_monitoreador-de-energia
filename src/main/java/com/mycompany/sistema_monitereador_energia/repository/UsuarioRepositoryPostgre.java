
package com.mycompany.sistema_monitereador_energia.repository;


import com.mycompany.sistema_monitereador_energia.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract  class UsuarioRepositoryPostgre implements UsuarioRepository{

    protected abstract Connection getConnection() throws SQLException;

    @Override
    public void agregarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuarios(nombre, contrasena) VALUES (?, ?)";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getContrasena());
        stmt.executeUpdate();
        System.out.println("Usuario agregado exitosamente: " + usuario.getNombre());
    } catch (SQLException e) {
        System.out.println("Error al agregar usuario: " + e.getMessage());
        e.printStackTrace();
    }
    }

    @Override
    public Usuario obtenerUsuario(int id) {
         String query = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
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
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
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
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuarios SET nombre = ?, contrasena = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
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
    try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {
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
    
    @Override
    public boolean validarUsuario(String nombre, String contrasena){
        String query = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, nombre);
        pstmt.setString(2, contrasena);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Autenticación exitosa para el usuario: " + nombre);
            return true;
        } else {
            System.out.println("Autenticación fallida para el usuario: " + nombre);
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Error al validar usuario: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
   }
}
