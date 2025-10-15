package interfaces;
import entities.Direccion;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IDireccionDAO {

    boolean agregar(Direccion direccion);

    boolean editar(Direccion direccion);

    boolean eliminar(Long id);

    Direccion buscarPorId(Long id);

    List<Direccion> obtenerTodas();
}
