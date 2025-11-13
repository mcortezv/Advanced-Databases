package mcortezv.app;

import org.bson.types.ObjectId;
import mcortezv.config.MongoClienteProvider;
import mcortezv.exception.DaoException;
import mcortezv.exception.EntityNotFoundException;
import mcortezv.model.Producto;
import mcortezv.model.Proveedor;
import mcortezv.repository.IProductoDAO;
import mcortezv.repository.ProductoDAO;

import java.time.Instant;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        MongoClienteProvider.INSTANCE.init();

        IProductoDAO dao = new ProductoDAO();

        try{
            ArrayList<String> categorias = new ArrayList<>();
            categorias.add("Bebidas");
            Producto producto = new Producto(
                    null,
                    "Monster Blanca",
                    45,
                    100L,
                    new Proveedor("Monster Energy Drink", "6681118936", "Mexico"),
                    categorias
            );
            producto.setCreatedAt(Instant.now());
            producto.setUpdatedAt(null);

            ObjectId id = dao.create(producto);
            System.out.println("Producto creado, con el id: " + id);

            dao.findById(id).ifPresent(productoo -> {
                System.out.println("--- Producto Encontrado ---");
                System.out.println("Nombre: " + productoo.getNombre());
                System.out.println("Precio: $" + productoo.getPrecio());
                System.out.println("Stock disponible: " + productoo.getStock());
                System.out.println("Categorías: " + productoo.getCategorias());
                System.out.println("Proovedor: " + productoo.getProveedor().getNombre());
            });

            producto.setPrecio(35);
            producto.setUpdatedAt(Instant.now());
            dao.update(producto);
            System.out.println("Producto actualizado con precio: 35");

            var all = dao.findAll();
            System.out.println("Total de productos: " + all.size());

            String nombre = "Monster Blanca";
            dao.findByNombre(nombre).ifPresent(productoo -> {
                System.out.println("--- Producto Encontrado ---");
                System.out.println("Nombre: " + productoo.getNombre());
                System.out.println("Precio: $" + productoo.getPrecio());
                System.out.println("Stock disponible: " + productoo.getStock());
                System.out.println("Categorías: " + productoo.getCategorias());
                System.out.println("Proovedor: " + productoo.getProveedor().getNombre());
            });

            String categoria = "Bebidas";
            dao.findByCategoria(categoria).ifPresent(productoo -> {
                System.out.println("--- Producto Encontrado ---");
                System.out.println("Nombre: " + productoo.getNombre());
                System.out.println("Precio: $" + productoo.getPrecio());
                System.out.println("Stock disponible: " + productoo.getStock());
                System.out.println("Categorías: " + productoo.getCategorias());
                System.out.println("Proovedor: " + productoo.getProveedor().getNombre());
            });

            dao.deleteById(id);
            System.out.println("Producto eliminado");


        }catch (EntityNotFoundException | DaoException exception){
            System.out.println("Error, "+ exception.getMessage());
        }
    }
}
