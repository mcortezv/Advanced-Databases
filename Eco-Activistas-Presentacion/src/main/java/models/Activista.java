/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * Clase que representa una entidad Activista.
 *
 * @author Cortez, Manuel;
 */
public class Activista {
    private int idActivista;
    private String nombre;
    private String telefono;
    private String fchIngreso;

    /**
     * Constructor vacio que instancia una objeto con atributos nulos.
     */
    public Activista() {}

    /**
     * Constructor principal que establece los atributos al valor de sus parametros.
     *
     * @param idActivista
     * @param nombre
     * @param telefono
     * @param fchIngreso
     */
    public Activista(int idActivista, String nombre, String telefono, String fchIngreso) {
        this.idActivista = idActivista;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fchIngreso = fchIngreso;
    }

    public int getIdActivista() {
        return idActivista;
    }

    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFchIngreso() {
        return fchIngreso;
    }

    public void setFchIngreso(String fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    @Override
    public String toString() {
        return "Activista{" +
                "idActivista=" + idActivista +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fchIngreso='" + fchIngreso + '\'' +
                '}';
    }
}
