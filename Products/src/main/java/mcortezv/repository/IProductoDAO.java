package mcortezv.repository;

import org.bson.types.ObjectId;
import mcortezv.exception.DaoException;
import mcortezv.exception.EntityNotFoundException;
import mcortezv.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoDAO {
    ObjectId create(Producto producto) throws DaoException;
    Optional<Producto> findById(ObjectId id) throws DaoException;
    List<Producto> findAll() throws DaoException;
    boolean update(Producto producto) throws DaoException, EntityNotFoundException;
    boolean deleteById(ObjectId id)throws DaoException, EntityNotFoundException;
    long deleteAll()throws DaoException;
    Optional<Producto> findByNombre(String nombre)throws DaoException, EntityNotFoundException;
    Optional<Producto> findByCategoria(String categoria)throws DaoException, EntityNotFoundException;
}
