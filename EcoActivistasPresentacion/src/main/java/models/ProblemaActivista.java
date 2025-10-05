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
public class ProblemaActivista {
    private int idProblema;
    private int idActivista;

    /**
     * Constructor vacio que instancia una objeto con atributos nulos.
     */
    public ProblemaActivista() {}

    /**
     * Constructor principal que establece los atributos al valor de sus parametros.
     *
     * @param idProblema
     * @param idActivista
     */
    public ProblemaActivista(int idProblema, int idActivista) {
        this.idProblema = idProblema;
        this.idActivista = idActivista;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public int getIdActivista() {
        return idActivista;
    }

    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }
}
