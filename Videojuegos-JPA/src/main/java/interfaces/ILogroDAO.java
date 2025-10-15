package interfaces;
import entities.Logro;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ILogroDAO {

    boolean agregar(Logro logro);

    boolean editar(Logro logro);

    boolean eliminar(Long id);

    Logro buscarPorId(Long id);

   List<Logro> obtenerTodos();

    List<Logro> logrosMayoresAlPromedio();

    Logro logroMasAlto();
}
