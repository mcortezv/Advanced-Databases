/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Activista;
import java.util.List;

/**
 * Interfaz que implementa la clase ActivistaDAO.
 *
 * @author Cortez, Manuel;
 */
public interface IActivistaDAO {

    /**
     * Metodo que permite guardar un nuevo activista.
     *
     * @param activista
     * @return boolean
     */
    boolean insertar(Activista activista);

    /**
     * Metodo que permite obtener un activista guardado por medio de su id.
     *
     * @param idActivista
     * @return Activista
     */
    Activista obtenerPorId(int idActivista);

    /**
     * Metodo que permite obtener una lista de todos los activistas guardados.
     * @return List<Activista>
     */
    List<Activista> obtenerTodos();

    /**
     * Metodo que permite actualizar a los activistas guardados.
     *
     * @param activista
     * @return boolean
     */
    boolean actualizar(Activista activista);

    /**
     * Metodo que elimina a un acivista guardado por medio de su id.
     *
     * @param idActivista
     * @return boolean
     */
    boolean eliminar(int idActivista);
}
