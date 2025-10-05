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
public class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefonos;

    /**
     * Constructor vacio que instancia una objeto con atributos nulos.
     */
    public Cliente(){}

    /**
     * Constructor principal que establece los atributos al valor de sus parametros.
     *
     * @param idCliente
     * @param nombre
     * @param direccion
     * @param telefonos
     */
    public Cliente(int idCliente, String nombre, String direccion, String telefonos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
}
