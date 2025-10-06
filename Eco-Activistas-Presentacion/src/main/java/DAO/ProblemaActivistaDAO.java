/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConexionDB;
import interfaces.IProblemaActivistaDAO;
import models.ProblemaActivista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite gestionar objetos ProblemaActivista directamente con la base de datos.
 *
 * @author Cortez
 */
public class ProblemaActivistaDAO implements IProblemaActivistaDAO {

    /**
     * Metodo que permite insertar un nuevo ProblemaActivista directamente a la base datos.
     *
     * @param pa ProblemaActivista
     * @return boolean
     */
    @Override
    public boolean insertar(ProblemaActivista pa) {
        String insert = "INSERT INTO Problema_Activista (idProblema, idActivista) VALUES (?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {

            ps.setInt(1, pa.getIdProblema());
            ps.setInt(2, pa.getIdActivista());
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Metodo que permite obtener un ProblemaActivista directamente de la base de datos por medio de su id.
     *
     * @param idProblema
     * @param idActivista
     * @return ProblemaActivista.
     */
    @Override
    public ProblemaActivista obtenerPorId(int idProblema, int idActivista) {
        String query = "SELECT * FROM Problema_Activista WHERE idProblema = ? AND idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idProblema);
            ps.setInt(2, idActivista);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ProblemaActivista pa = new ProblemaActivista();
                    pa.setIdProblema(rs.getInt("idProblema"));
                    pa.setIdActivista(rs.getInt("idActivista"));
                    return pa;
                }
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     * Metodo que permite obtener todos las relaciones ProblemaActivista directamente de la base de datos.
     *
     * @return List<ProblemaActivista>
     */
    @Override
    public List<ProblemaActivista> obtenerTodos() {
        List<ProblemaActivista> lista = new ArrayList<>();
        String query = "SELECT * FROM Problema_Activista";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ProblemaActivista pa = new ProblemaActivista();
                pa.setIdProblema(rs.getInt("idProblema"));
                pa.setIdActivista(rs.getInt("idActivista"));
                lista.add(pa);
            }
        } catch (SQLException ex) {
            return null;
        }
        return lista;
    }

    /**
     * Metod que permite eliminar un ProblemaActivista directamente de la base de datos por medio de su id.
     *
     * @param idProblema
     * @param idActivista
     * @return boolean
     */
    @Override
    public boolean eliminar(int idProblema, int idActivista) {
        String delete = "DELETE FROM Problema_Activista WHERE idProblema = ? AND idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(delete)) {
            ps.setInt(1, idProblema);
            ps.setInt(2, idActivista);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
}
