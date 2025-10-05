/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConexionDB;
import interfaces.IClienteDAO;
import models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite gestionar objetos Cliente de la base de datos.
 *
 * @author Cortez, Manuel;
 */
public class ClienteDAO implements IClienteDAO {

    /**
     * Metodo que inserta un cliente directamente en la base de datos.
     *
     * @param cliente
     * @return boolean.
     */
    @Override
    public boolean insertar(Cliente cliente) {
        String insert = "INSERT INTO Cliente(nombre, direccion, telefonos) VALUES(?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que permite obtener un cliente por medio de su id directamente de la base de datos.
     *
     * @param idCliente
     * @return Cliente
     */
    @Override
    public Cliente obtenerPorId(int idCliente) {
        String query = "SELECT * FROM Cliente WHERE idCliente = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setIdCliente(rs.getInt("idCliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setTelefonos(rs.getString("telefonos"));
                    return c;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo que permite obtener una lista con todos los clientes registrados en la base de datos.
     *
     * @return List<Cliente>
     */
    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> lista = new ArrayList<>();
        String query = "SELECT * FROM Cliente";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefonos(rs.getString("telefonos"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Metodo que permite actualizar un cliente directamente en la base de datos.
     *
     * @param cliente
     * @return boolean
     */
    @Override
    public boolean actualizar(Cliente cliente) {
        String update = "UPDATE Cliente SET nombre = ?, direccion = ?, telefonos = ? WHERE idCliente = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(update)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            ps.setInt(4, cliente.getIdCliente());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Metodo que permite elminar un cliente directamente de la base de datos por medio de su id.
     *
     * @param idCliente
     * @return boolean
     */
    @Override
    public boolean eliminar(int idCliente) {
        String delete = "DELETE FROM Cliente WHERE idCliente = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(delete)) {
            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
}
