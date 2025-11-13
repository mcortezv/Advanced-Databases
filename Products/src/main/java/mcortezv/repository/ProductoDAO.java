package mcortezv.repository;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.types.ObjectId;
import mcortezv.config.MongoClienteProvider;
import mcortezv.exception.DaoException;
import mcortezv.exception.EntityNotFoundException;
import mcortezv.model.Producto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAO implements IProductoDAO{

    private final MongoCollection<Producto> col;

    public ProductoDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("productos",Producto.class);
    }

    @Override
    public ObjectId create(Producto producto) {
        try {
            producto.setCreatedAt(Instant.now());
            col.insertOne(producto);
            return producto.get_id();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public Optional<Producto> findById(ObjectId id) {
        try{
            return Optional.ofNullable(col.find(Filters.eq("_id", id)).first());
        }catch (MongoException ex){
            throw new DaoException("Error consultando al producto");
        }
    }

    @Override
    public List<Producto> findAll() {
        try{
            return col.find().into(new ArrayList<>());
        }catch (MongoException ex){
            throw new DaoException("Error consultando todos los productos");
        }
    }

    @Override
    public boolean update(Producto producto) throws DaoException, EntityNotFoundException {
        try {
            var result = col.updateOne(
                    Filters.eq("_id", producto.get_id()),
                    Updates.combine(
                            Updates.set("nombre", producto.getNombre()),
                            Updates.set("precio", producto.getPrecio()),
                            Updates.set("stock", producto.getStock()),
                            Updates.set("proveedor", producto.getProveedor()),
                            Updates.set("actualizado_en", producto.getUpdatedAt())
                    )
            );
            if (result.getMatchedCount() == 0)
                throw new EntityNotFoundException("Producto no encontrado: " + producto.get_id());

            return result.getModifiedCount() > 0;
        } catch (MongoException ex) {
            throw new DaoException("Error actualizando el producto");
        }
    }


    public boolean deleteById(ObjectId id) {
        try{
            var result = col.deleteOne(Filters.eq("_id", id));
            if(result.getDeletedCount() == 0){
                throw new EntityNotFoundException("Producto no encontrado: " + id);
            }
            return true;
        }catch (MongoException e){
            throw new DaoException("Error eliminando el producto");
        }
    }


    @Override
    public long deleteAll() {
        try {
            return col.deleteMany(Filters.exists("_id")).getDeletedCount();
        } catch (MongoException e) {
            throw new DaoException("Error eliminando todos los productos");
        }
    }

    @Override
    public Optional<Producto> findByNombre(String nombre) {
        try {
            return Optional.ofNullable(col.find(Filters.eq("nombre", nombre)).first());
        } catch (MongoException e) {
            throw new DaoException("Error consultando usuario por nombre");
        }
    }

    @Override
    public Optional<Producto> findByCategoria(String categoria) {
        try {
            return Optional.ofNullable(col.find(Filters.eq("categorias", categoria)).first());
        } catch (MongoException e) {
            throw new DaoException("Error consultando usuario por categoria");
        }
    }
}