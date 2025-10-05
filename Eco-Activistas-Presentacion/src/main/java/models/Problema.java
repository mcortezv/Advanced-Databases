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
public class Problema {
    private  int idProblema;
    private String fchIni;
    private String fchFin;
    private String estado;
    private int idCliente;

    /**
     * Constructor vacio que instancia una objeto con atributos nulos.
     */
    public Problema(){}

    /**
     * Constructor principal que establece los atributos al valor de sus parametros.
     *
     * @param idProblema
     * @param fchIni
     * @param fchFin
     * @param estado
     * @param idCliente
     */
    public Problema(int idProblema, String fchIni, String fchFin, String estado, int idCliente) {
        this.idProblema = idProblema;
        this.fchIni = fchIni;
        this.fchFin = fchFin;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public String getFchIni() {
        return fchIni;
    }

    public void setFchIni(String fchIni) {
        this.fchIni = fchIni;
    }

    public String getFchFin() {
        return fchFin;
    }

    public void setFchFin(String fchFin) {
        this.fchFin = fchFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Problema{" +
                "idProblema=" + idProblema +
                ", fchIni='" + fchIni + '\'' +
                ", fchFin='" + fchFin + '\'' +
                ", estado='" + estado + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}
