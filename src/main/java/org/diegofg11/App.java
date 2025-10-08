package org.diegofg11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase principal de la aplicación JavaFX.
 * <p>
 * Extiende de {@link Application} y define el punto de entrada para
 * inicializar y mostrar la interfaz gráfica. Carga el archivo FXML
 * {@code tabla.fxml}, establece la escena y configura la ventana principal.
 * </p>
 */
public class App extends Application {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Metodo principal de inicialización de JavaFX.
     * <ul>
     *   <li>Carga el archivo FXML que define la interfaz.</li>
     *   <li>Crea la escena con un tamaño inicial de 600x500 píxeles.</li>
     *   <li>Configura las dimensiones mínimas de la ventana.</li>
     *   <li>Establece el título de la ventana.</li>
     *   <li>Muestra la ventana en pantalla.</li>
     * </ul>
     *
     * @param stage ventana principal de la aplicación, proporcionada por JavaFX
     * @throws Exception si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws Exception {

        logger.info("Lanzando la aplicación");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/tabla.fxml"));
        Scene scene = new Scene(loader.load(), 600, 500);
        stage.setScene(scene);
        stage.setMinWidth(543);
        stage.setMinHeight(309);
        stage.setTitle("Adding/Deleting Rows in a TableView");
        stage.show();

        logger.info("Ventana principal mostrada correctamente");
    }

    /**
     * Metodo de entrada estándar de la aplicación.
     * <p>
     * Llama a {@link Application#launch(String...)} para iniciar el ciclo de vida de JavaFX,
     * lo que finalmente invoca el metodo {@link #start(Stage)}.
     * </p>
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}