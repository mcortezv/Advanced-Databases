/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;
import DAO.ProductoDAO;
import models.Producto;

/**
 *
 * @author Cortez, Manuel;
 */
public class Main {

    public static void main (String[] args) {
        ProductoDAO dao = new ProductoDAO () ;

        Producto pl = new Producto();
        pl.setNombre("Laptop");
        pl.setPrecio(15000.50);
        dao.insertar(pl);

        Producto buscado = dao.buscar(1);
        System.out.println("Producto encontrado: " + buscado.getNombre ()); ;
        buscado.setPrecio(14000.00);
        dao.actualizar(buscado);

        dao.eliminar(1);
    }
}
