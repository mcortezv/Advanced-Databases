/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.SuperHeroe;

import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface ISuperHeroeDAO {

    void insertar(SuperHeroe superHeroe);

    void actualizar(SuperHeroe superHeroe);

    void eliminar(Long id);

    SuperHeroe buscar(Long id);

    List<SuperHeroe> listar();
    
}
