package org.diegofg11.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 * Clase {@code Conexion} que gestiona la conexión a la base de datos
 * de forma asíncrona utilizando {@link CompletableFuture}.
 * <p>
 * Los datos de conexión (URL, usuario y contraseña) se obtienen desde la clase
 * {@link Config}, y el método {@link #getConnection()} devuelve un
 * {@code CompletableFuture<Connection>} que se resuelve en un hilo en segundo plano.
 * </p>
 *
 * @author diegofg11
 * @version 2.0 (asíncrona)
 * @see Config
 */
public class Conexion {

    private static final String URL = Config.get("db.url");
    private static final String USER = Config.get("db.user");
    private static final String PASSWORD = Config.get("db.password");

    /**
     * Establece una conexión con la base de datos de forma asíncrona.
     * <p>
     * Este método no bloquea el hilo principal (por ejemplo, el hilo de JavaFX).
     * </p>
     *
     * @return un {@code CompletableFuture<Connection>} que se completa cuando
     *         la conexión se establece correctamente o se produce un error.
     */
    public static CompletableFuture<Connection> getConnection() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al conectar con la base de datos", e);
            }
        });
    }
}

