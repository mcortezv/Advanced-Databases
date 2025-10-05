/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConexionDB;
import interfaces.IProblemaDAO;
import models.Problema;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite gestionar objetos Problema directamente con la base de datos.
 *
 * @author Cortez, Manuel;
 */
public class ProblemaDAO implements IProblemaDAO {

    /**
     * Metodo quer permite insertar un nuevo problema directamente en la base de datos.
     *
     * @param problema
     * @return boolean
     */
    @Override
    public boolean insertar(Problema problema) {
        String insert = "INSERT INTO Problema (fch_ini, fch_fin, estado, idCliente) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {
            ps.setDate(1, Date.valueOf(problema.getFchIni()));
            if (problema.getFchFin() != null) {
                ps.setDate(2, Date.valueOf(problema.getFchFin()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            ps.setString(3, problema.getEstado());
            ps.setInt(4, problema.getIdCliente());
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que permite obtener un problema directamente de la base de datos por medio de su id.
     *
     * @param idProblema
     * @return Problema
     */
    @Override
    public Problema obtenerPorId(int idProblema) {
        String query = "SELECT * FROM Problema WHERE idProblema = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idProblema);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Problema p = new Problema();
                    p.setIdProblema(rs.getInt("idProblema"));
                    p.setFchIni(String.valueOf(rs.getDate("fch_ini").toLocalDate()));
                    Date fchFin = rs.getDate("fch_fin");
                    if (fchFin != null) {
                        p.setFchFin(String.valueOf(fchFin.toLocalDate()));
                    }
                    p.setEstado(rs.getString("estado"));
                    p.setIdCliente(rs.getInt("idCliente"));
                    return p;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo que permite obtener todos los Problemas registrados directamente de la base de datos.
     *
     * @return List<Problema>
     */
    @Override
    public List<Problema> obtenerTodos() {
        List<Problema> lista = new ArrayList<>();
        String query = "SELECT * FROM Problema";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Problema p = new Problema();
                p.setIdProblema(rs.getInt("idProblema"));
                p.setFchIni(String.valueOf(rs.getDate("fch_ini").toLocalDate()));
                Date fchFin = rs.getDate("fch_fin");
                if (fchFin != null) {
                    p.setFchFin(String.valueOf(fchFin.toLocalDate()));
                }
                p.setEstado(rs.getString("estado"));
                p.setIdCliente(rs.getInt("idCliente"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Metodo que permite actualizar una problema directamente de la base de datos.
     *
     * @param problema
     * @return boolean
     */
    @Override
    public boolean actualizar(Problema problema) {
        String update = "UPDATE Problema SET fch_ini = ?, fch_fin = ?, estado = ?, idCliente = ? WHERE idProblema = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(update)) {
            ps.setDate(1, Date.valueOf(problema.getFchIni()));
            if (problema.getFchFin() != null) {
                ps.setDate(2, Date.valueOf(problema.getFchFin()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            ps.setString(3, problema.getEstado());
            ps.setInt(4, problema.getIdCliente());
            ps.setInt(5, problema.getIdProblema());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que permite eliminiar un problema directamente de la base de datos por medio de su id.
     *
     * @param idProblema
     * @return boolean
     */
    @Override
    public boolean eliminar(int idProblema) {
        String delete = "DELETE FROM Problema WHERE idProblema = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(delete)) {
            ps.setInt(1, idProblema);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
