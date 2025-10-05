/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConexionDB;
import interfaces.IActivistaDAO;
import models.Activista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite gestionar la base datos a partir de los objetos Activista que
 * recibe, implementa la intrefaz IActivistaDAO.
 *
 * @author Cortez, Manuel;
 */
public class ActivistaDAO implements IActivistaDAO {

    /**
     * Metodo que inserta un ativista en la base de datos.
     *
     * @param activista
     * @return boolean
     */
    @Override
    public boolean insertar(Activista activista) {
        String insert = "INSERT INTO Activista(nombre, telefono, fchIngreso) VALUES(?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {
            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getTelefono());
            ps.setDate(3, Date.valueOf(activista.getFchIngreso()));
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Motodo que retorna un activista por su id, null si no lo encuentra.
     *
     * @param idActivista
     * @return Activista
     */
    @Override
    public Activista obtenerPorId(int idActivista) {
        String query = "SELECT * FROM Activista WHERE idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idActivista);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Activista a = new Activista();
                    a.setIdActivista(rs.getInt("idActivista"));
                    a.setNombre(rs.getString("nombre"));
                    a.setTelefono(rs.getString("telefono"));
                    a.setFchIngreso(String.valueOf(rs.getDate("fchIngreso").toLocalDate()));
                    return a;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo que retorna una lista con todos los Activistas de la base de datos.
     *
     * @return List<Activista>
     */
    @Override
    public List<Activista> obtenerTodos() {
        List<Activista> lista = new ArrayList<>();
        String query = "SELECT * FROM Activista";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Activista a = new Activista();
                a.setIdActivista(rs.getInt("idActivista"));
                a.setNombre(rs.getString("nombre"));
                a.setTelefono(rs.getString("telefono"));
                a.setFchIngreso(String.valueOf(rs.getDate("fchIngreso").toLocalDate()));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Metodo que actualiza a una activista de la base de datos.
     *
     * @param activista
     * @return boolean
     */
    @Override
    public boolean actualizar(Activista activista) {
        String update = "UPDATE Activista SET nombre = ?, telefono = ?, fchIngreso = ? WHERE idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(update)) {
            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getTelefono());
            ps.setDate(3, Date.valueOf(activista.getFchIngreso()));
            ps.setInt(4, activista.getIdActivista());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que permite eliminar a una activista de la base de datos por medio de su id.
     *
     * @param idActivista
     * @return boolean
     */
    @Override
    public boolean eliminar(int idActivista) {
        String delete = "DELETE FROM Activista WHERE idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(delete)) {
            ps.setInt(1, idActivista);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {

            return false;
        }
    }
}
