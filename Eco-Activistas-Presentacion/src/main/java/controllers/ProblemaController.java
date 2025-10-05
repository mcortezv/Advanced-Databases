/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.ProblemaDAO;
import interfaces.IProblemaDAO;
import models.Problema;
import java.util.List;

/**
 * Clase que permite controlar las  entidades Problema.
 *
 * @author Cortez, Manuel;
 */
public class ProblemaController {
    private final IProblemaDAO problemaDAO;
    private static int contador = 100;

    /**
     * Constructor vacio que instancia un nuevo ProblemaDAO.
     */
    public ProblemaController() {
        this.problemaDAO = new ProblemaDAO();
    }

    /**
     * Metodo que agrega una nuevo problema a la base de datos, valida los
     * parametros e instancia los objetos.
     *
     * @param fchIni
     * @param fchFin
     * @param estado
     * @param idCliente
     * @return boolean
     */
    public boolean agregarProblema(String fchIni, String fchFin, String estado, int idCliente) {
        if (fchIni == null || fchIni.trim().isEmpty()) return false;
        if (estado == null || estado.trim().isEmpty()) return false;
        if (idCliente <= 0) return false;

        Problema problema = new Problema(contador, fchIni, fchFin, estado, idCliente);
        contador++;
        return this.problemaDAO.insertar(problema);
    }

    /**
     * Metodo que permite obtener un problema por medio de su id.
     *
     * @param id
     * @return Problema
     */
    public Problema obtenerProblema(int id) {
        return this.problemaDAO.obtenerPorId(id);
    }

    /**
     * Metodo que retorna una lista con todos los problemas registrados
     * en la base de datos.
     *
     * @return Lis<Problema>
     */
    public List<Problema> listarProblemas() {
        return this.problemaDAO.obtenerTodos();
    }

    /**
     * Metodo que permite actualizar un problema.
     *
     * @param idProblema
     * @param fchIni
     * @param fchFin
     * @param estado
     * @param idCliente
     * @return boolean
     */
    public boolean actualizarProblema(int idProblema, String fchIni, String fchFin, String estado, int idCliente) {
        if (idProblema <= 0) return false;
        Problema problema = new Problema(idProblema, fchIni, fchFin, estado, idCliente);
        return this.problemaDAO.actualizar(problema);
    }

    /**
     * Metodo que permite eliminar un problema de la base de datos.
     *
     * @param id
     * @return boolean
     */
    public boolean eliminarProblema(int id) {
        if (id <= 0) return false;
        return this.problemaDAO.eliminar(id);
    }
}
