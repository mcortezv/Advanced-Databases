package interfaces;
import entities.Jugador;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IJugadorDAO {

    boolean agregar(Jugador jugador);

    boolean editar(Jugador jugador);

    boolean eliminar(Long id);

    Jugador buscarPorId(Long id);

    List<Jugador> obtenerTodos();

    List<Object[]> jugadoresConMasVideojuegos();

    List<Jugador> jugadoresPorColoniaYVideojuegos(String colonia);

    List<Jugador> jugadoresOrdenadosPorEdadDesc();

    List<Object[]> jugadoresConDireccionOrdenados();
}
