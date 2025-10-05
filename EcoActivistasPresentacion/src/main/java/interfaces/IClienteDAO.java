/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Cliente;
import java.util.List;

/**
 * Interfaz que implementa la clase ClienteDAO.
 *
 * @author Cortez, Manuel;
 */
public interface IClienteDAO {

    /**
     * Metodo que permite guardar un nuevo Cliente.
     *
     * @param cliente
     * @return boolean
     */
    boolean insertar(Cliente cliente);

    /**
     * Metodo que permite obtener un cliente guardado por medio de su id.
     *
     * @param idCliente
     * @return Cliente
     */
    Cliente obtenerPorId(int idCliente);

    /**
     * Metodo que permite obtener una lista de todos los clientes guardados.
     * @return List<Cliente>
     */
    List<Cliente> obtenerTodos();

    /**
     * Metodo que permite actualizar a los clientes guardados.
     *
     * @param cliente
     * @return boolean
     */
    boolean actualizar(Cliente cliente);

    /**
     * Metodo que elimina a un cliente guardado por medio de su id.
     *
     * @param idCliente
     * @return boolean
     */
    boolean eliminar(int idCliente);
}
