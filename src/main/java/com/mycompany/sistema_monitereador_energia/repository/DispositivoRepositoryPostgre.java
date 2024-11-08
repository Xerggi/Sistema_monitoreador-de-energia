
package com.mycompany.sistema_monitereador_energia.repository;

import com.mycompany.sistema_monitereador_energia.model.Dispositivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class DispositivoRepositoryPostgre implements DispositivoRepository{

    protected abstract Connection getConnection() throws SQLException;
    @Override
    public void agregarDispositivo(Dispositivo dispositivo) {
        String query = "INSERT INTO dispositivos(tipo, consumo_estimado ,consumo_actual,usuario_id) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, dispositivo.getTipo());
            stmt.setDouble(2,dispositivo.getConsumoEstimado());
            stmt.setDouble(3,dispositivo.getConsumoActual());
            stmt.setInt(4, dispositivo.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dispositivo> obtenerDispositivosUsuario(int usuarioId) {
        List<Dispositivo> dispositivos = new ArrayList<>();
        String query = "SELECT * FROM dispositivos WHERE usuario_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, usuarioId); 
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Dispositivo dispositivo = new Dispositivo(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getDouble("consumo_estimado"),
                        rs.getDouble("consumo_actual"),
                        rs.getInt("usuario_id")
                    );
                    dispositivos.add(dispositivo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dispositivos;
    }

    @Override
    public void eliminarDispositivo(int id) {
        String query = "DELETE FROM dispositivos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}  

