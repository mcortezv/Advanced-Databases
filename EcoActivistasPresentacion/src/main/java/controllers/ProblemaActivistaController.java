/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.ProblemaActivistaDAO;
import interfaces.IProblemaActivistaDAO;
import models.ProblemaActivista;
import java.util.List;

/**
 *
 * Clase que permite controlar las entidades ProblemaActivista.
 *
 * @author Cortez, Manuel;
 */
public class ProblemaActivistaController {
    private final IProblemaActivistaDAO problemaActivistaDAO;

    /**
     * Constructor vacio que instancia un nuevo objeto ProblemaActivista.
     */
    public ProblemaActivistaController() {
        this.problemaActivistaDAO = new ProblemaActivistaDAO();
    }

    /**
     * Metodo que permite relacionar un Problema con un Activista.
     *
     * @param idProblema
     * @param idActivista
     * @return boolean
     */
    public boolean asignarProblemaActivista(int idProblema, int idActivista) {
        ProblemaActivista pa = new ProblemaActivista(idProblema, idActivista);
        return this.problemaActivistaDAO.insertar(pa);
    }

    /**
     * Metodo que permite obtener la relacion de ProblemaActivista por medio del id.
     *
     * @param idProblema
     * @param idActivista
     * @return ProblemaActivista.
     */
    public ProblemaActivista obtenerRelacion(int idProblema, int idActivista) {
        return ((ProblemaActivistaDAO) problemaActivistaDAO).obtenerPorId(idProblema, idActivista);
    }

    /**
     * Metodo que retorna una lista con todas las relaciones ProblemaActivista regisradas en la base de datos.
     *
     * @return List<ProblemaActista>
     */
    public List<ProblemaActivista> listarRelaciones() {
        return this.problemaActivistaDAO.obtenerTodos();
    }

    /**
     * Metodo que permite elimiar una relacion de ProblemaActivista de la base de datos.
     *
     * @param idProblema
     * @param idActivista
     * @return boolean
     */
    public boolean eliminarRelacion(int idProblema, int idActivista) {
        return ((ProblemaActivistaDAO) problemaActivistaDAO).eliminar(idProblema, idActivista);
    }
}
