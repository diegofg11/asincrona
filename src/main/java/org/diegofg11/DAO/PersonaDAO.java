package org.diegofg11.DAO;

import org.diegofg11.Conexion.Conexion;
import org.diegofg11.Modelos.Persona;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * DAO asíncrono para la entidad {@link Persona}.
 * Gestiona operaciones CRUD sobre la tabla Personas (id, nombre, apellido, fecha).
 */
public class PersonaDAO {

    public CompletableFuture<List<Persona>> obtenerPersonas() {
        return Conexion.getConnection().thenApply(conn -> {
            List<Persona> lista = new ArrayList<>();
            String sql = "SELECT * FROM persona";

            try (conn; Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Persona p = new Persona(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getDate("fecha").toLocalDate()
                    );
                    lista.add(p);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return lista;
        });
    }

    public CompletableFuture<Void> insertarPersona(Persona persona) {
        return Conexion.getConnection().thenAccept(conn -> {
            String sql = "INSERT INTO Personas (nombre, apellido, fecha) VALUES (?, ?, ?)";

            try (conn; PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, persona.getNombre());
                pstmt.setString(2, persona.getApellido());
                pstmt.setDate(3, Date.valueOf(persona.getFecha()));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public CompletableFuture<Void> actualizarPersona(Persona persona) {
        return Conexion.getConnection().thenAccept(conn -> {
            String sql = "UPDATE Personas SET nombre = ?, apellido = ?, fecha = ? WHERE id = ?";

            try (conn; PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, persona.getNombre());
                pstmt.setString(2, persona.getApellido());
                pstmt.setDate(3, Date.valueOf(persona.getFecha()));
                pstmt.setInt(4, persona.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public CompletableFuture<Void> eliminarPersona(int id) {
        return Conexion.getConnection().thenAccept(conn -> {
            String sql = "DELETE FROM Personas WHERE id = ?";

            try (conn; PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}



