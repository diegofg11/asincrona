package org.diegofg11.Modelos;

import java.time.LocalDate;

/**
 * Representa a una Persona con atributos básicos como id, nombre, apellido y fecha de nacimiento.
 * Incluye getters y setters compatibles con JavaFX y la base de datos.
 */
public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fecha;

    public Persona() {}

    public Persona(int id, String nombre, String apellido, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + fecha + ")";
    }
}

