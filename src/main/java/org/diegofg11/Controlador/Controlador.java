package org.diegofg11.Controlador;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.diegofg11.DAO.PersonaDAO;
import org.diegofg11.Modelos.Persona;

import java.time.LocalDate;

public class Controlador {

    @FXML
    private TableView<Persona> tablaPersonas;

    @FXML
    private TableColumn<Persona, Integer> colId;

    @FXML
    private TableColumn<Persona, String> colNombre;

    @FXML
    private TableColumn<Persona, String> colApellido;

    @FXML
    private TableColumn<Persona, LocalDate> colFecha;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private DatePicker dpFecha;

    private final PersonaDAO personaDAO = new PersonaDAO();
    private final ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tablaPersonas.setItems(listaPersonas);

        cargarPersonas();
    }

    private void cargarPersonas() {
        personaDAO.obtenerPersonas().thenAccept(personas ->
                Platform.runLater(() -> listaPersonas.setAll(personas))
        );
    }

    @FXML
    private void agregarPersona() {
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || dpFecha.getValue() == null) {
            return;
        }

        Persona persona = new Persona(0, txtNombre.getText(), txtApellido.getText(), dpFecha.getValue());
        personaDAO.insertarPersona(persona).thenRun(() -> {
            cargarPersonas();
            Platform.runLater(this::limpiarCampos);
        });
    }

    @FXML
    private void actualizarPersona() {
        Persona seleccionada = tablaPersonas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) return;

        seleccionada.setNombre(txtNombre.getText());
        seleccionada.setApellido(txtApellido.getText());
        seleccionada.setFecha(dpFecha.getValue());

        personaDAO.actualizarPersona(seleccionada).thenRun(() -> {
            cargarPersonas();
            Platform.runLater(this::limpiarCampos);
        });
    }

    @FXML
    private void eliminarPersona() {
        Persona seleccionada = tablaPersonas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) return;

        personaDAO.eliminarPersona(seleccionada.getId()).thenRun(() -> {
            cargarPersonas();
            Platform.runLater(this::limpiarCampos);
        });
    }

    @FXML
    private void handleDelete() {
        eliminarPersona();
    }

    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        dpFecha.setValue(null);
        tablaPersonas.getSelectionModel().clearSelection();
    }


    @FXML
    private void handleRestore() {
        limpiarCampos();
    }

    @FXML
    private void handleClose() {
        // Cierra correctamente la aplicación JavaFX
        Platform.exit();
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText("Aplicación Asíncrona");
        alert.setContentText("Proyecto realizado por Diego Fernández.\nConexión asíncrona a base de datos MariaDB.");
        alert.showAndWait();
    }

    @FXML
    private void handleAdd() {
        agregarPersona();
    }
}



