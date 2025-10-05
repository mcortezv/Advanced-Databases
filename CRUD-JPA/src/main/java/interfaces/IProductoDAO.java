/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;
import models.Producto;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IProductoDAO {

    void insertar (Producto p);

    Producto buscar (int id);

    void actualizar (Producto p);

    void eliminar (int id);
}
