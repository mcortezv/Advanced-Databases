/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.ProblemaActivista;
import java.util.List;

/**
 * Interfaz que implementa la clase ProblemaActivistaDAO.
 *
 * @author Cortez, Manuel;
 */
public interface IProblemaActivistaDAO {

    /**
     * Metodo que permite guardar un nuevo ProblemaActivista.
     *
     * @param problemaActivista
     * @return boolean
     */
    boolean insertar(ProblemaActivista problemaActivista);

    /**
     * Metodo que permite obtener un ProblemaActivista guardado por medio de su id.
     *
     * @param idProblema
     * @param idActivista
     * @return ProblemaActivista
     */
    ProblemaActivista obtenerPorId(int idProblema,int idActivista);

    /**
     * Metodo que permite obtener una lista de todos los ProblemaActivista guardados.
     * @return List<ProblemaActivista>
     */
    List<ProblemaActivista> obtenerTodos();


    /**
     * Metodo que elimina a un ProblemaActivista guardado por medio de su id.
     *
     * @param idProblema
     * @param idActivista
     * @return boolean
     */
    boolean eliminar(int idProblema, int idActivista);
}
