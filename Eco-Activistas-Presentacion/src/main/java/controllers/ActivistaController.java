/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.ActivistaDAO;
import interfaces.IActivistaDAO;
import models.Activista;
import view.MainFrame;

import java.util.List;

/**
 *
 * Clase que permite controlar las entidades activstas.
 *
 * @author Cortez, Manuel;
 */
public class ActivistaController {
    private final IActivistaDAO activistaDAO;
    private static int contador = 100;

    /**
     * Constructor vacio que instancia una nueva instancia de la clase ActivistaDAO.
     */
    public ActivistaController() {
        this.activistaDAO = new ActivistaDAO();
    }

    /**
     * Metodo que permite agregar un neuvo activista en la base de datos, se encarga de
     * las validaciones e instanciacion de objetos.
     *
     * @param nombre
     * @param correo
     * @param telefono
     * @return boolean
     */
    public boolean agregarActivista(String nombre, String correo, String telefono) {
        if (correo == null) correo = "";
        if (telefono == null) telefono = "";
        Activista activista = new Activista(contador, nombre, correo, telefono);
        contador++;
        return this.activistaDAO.insertar(activista);
    }

    /**
     * Metodo que permite obtener a un Activista por su id.
     *
     * @param id
     * @return Activista
     */
    public Activista obtenerActivista(int id) {
        return this.activistaDAO.obtenerPorId(id);
    }

    /**
     * Metodo que retorna una lista con todos los activistas de la base de datos.
     *
     * @return List<Activista>
     */
    public List<Activista> listarActivistas() {
        return this.activistaDAO.obtenerTodos();
    }

    /**
     * Metodo que permite actualizar a un activista.
     *
     * @param id
     * @param nombre
     * @param correo
     * @param telefono
     * @return boolean
     */
    public boolean actualizarActivista(int id, String nombre, String correo, String telefono) {
        Activista activista = new Activista(id, nombre, correo, telefono);
        return this.activistaDAO.actualizar(activista);
    }

    /**
     * Metodo qeu permite eliminar a un activista por su id.
     *
     * @param id
     * @return boolean
     */
    public boolean eliminarActivista(int id) {
        return this.activistaDAO.eliminar(id);
    }
}
