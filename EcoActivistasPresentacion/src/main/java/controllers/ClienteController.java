/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.ClienteDAO;
import interfaces.IClienteDAO;
import models.Cliente;
import java.util.List;

/**
 *
 * Clase que permite controlar las entidades Cliente.
 *
 * @author Cortez, Manuel;
 */
public class ClienteController {
    private final IClienteDAO clienteDAO;

    /**
     * Constructor vacio que instancia un nuevo objeto ClienteDAO.
     */
    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    /**
     * Metodo que permite agregar a un nuevo cliente a la base de datos,
     * valida los parametros y se encarga de la instanciacion.
     * @param nombre
     * @param direccion
     * @param telefonos
     * @return boolean
     */
    public boolean agregarCliente(String nombre, String direccion, String telefonos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (direccion == null) direccion = "";
        if (telefonos == null) telefonos = "";
        Cliente cliente = new Cliente(0, nombre, direccion, telefonos);
        return this.clienteDAO.insertar(cliente);
    }

    /**
     * Metodo que petmite obtener a un cliente por medio de su id.
     *
     * @param id
     * @return Cliente
     */
    public Cliente obtenerCliente(int id) {
        return this.clienteDAO.obtenerPorId(id);
    }

    /**
     * Metodo que regresa una lista con todos los clientes registrados en la base de datos.
     *
     * @return List<Cliente>
     */
    public List<Cliente> listarClientes() {
        return this.clienteDAO.obtenerTodos();
    }

    /**
     * Metodo que permite actualizar a un cliente.
     *
     * @param id
     * @param nombre
     * @param direccion
     * @param telefonos
     * @return boolean
     */
    public boolean actualizarCliente(int id, String nombre, String direccion, String telefonos) {
        Cliente cliente = new Cliente(id, nombre, direccion, telefonos);
        return this.clienteDAO.actualizar(cliente);
    }

    /**
     * Metodo que permite eliminar a un cliente por medio de su id.
     *
     * @param id
     * @return boolean
     */
    public boolean eliminarCliente(int id) {
        return this.clienteDAO.eliminar(id);
    }
}
