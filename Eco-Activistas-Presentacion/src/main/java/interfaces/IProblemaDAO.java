/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Problema;
import java.util.List;

/**
 *
 * Interfaz que implementa la clase ProblemaDAO.
 *
 * @author Cortez, Manuel;
 */
public interface IProblemaDAO {

    /**
     * Metodo que permite guardar un nuevo Problema.
     *
     * @param problema
     * @return boolean
     */
    boolean insertar(Problema problema);

    /**
     * Metodo que permite obtener un problema guardado por medio de su id.
     *
     * @param idProblema
     * @return Problema
     */
    Problema obtenerPorId(int idProblema);

    /**
     * Metodo que permite obtener una lista de todos los Problemas guardados.
     * @return List<Problema>
     */
    List<Problema> obtenerTodos();

    /**
     * Metodo que permite actualizar a los problemas guardados.
     *
     * @param problema
     * @return boolean
     */
    boolean actualizar(Problema problema);

    /**
     * Metodo que elimina a un problema guardado por medio de su id.
     *
     * @param idProblema
     * @return boolean
     */
    boolean eliminar(int idProblema);
}
