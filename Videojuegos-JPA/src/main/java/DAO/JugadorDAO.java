package DAO;
import entities.Jugador;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class JugadorDAO {
    private EntityManager em;

    public JugadorDAO(EntityManager em) {
        this.em = em;
    }

    public boolean agregar(Jugador j) {
        try {
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public boolean editar(Jugador j) {
        try {
            em.getTransaction().begin();
            em.merge(j);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public boolean eliminar(Long id) {
        try {
            em.getTransaction().begin();
            Jugador j = em.find(Jugador.class, id);
            if(j != null) em.remove(j);
            em.getTransaction().commit();
            return j != null;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public Jugador buscarPorId(Long id) {
        return em.find(Jugador.class, id);
    }

    public List<Jugador> obtenerTodos() {
        try {
            return em.createQuery("SELECT j FROM Jugador j", Jugador.class).getResultList();
        } catch(Exception e) {
            return new ArrayList<Jugador>();
        }
    }

    public List<Object[]> jugadoresConMasVideojuegos() {
        try {
            return em.createQuery("SELECT j.pseudonimo, COUNT(v) FROM Jugador j JOIN j.id_videojuego v GROUP BY j.pseudonimo ORDER BY COUNT(v) DESC", Object[].class)
                    .getResultList();
        } catch(Exception e) {
            return new ArrayList<Object[]>();
        }
    }

    public List<Jugador> jugadoresOrdenadosPorEdadDesc() {
        try {
            return em.createQuery("SELECT j FROM Jugador j ORDER BY j.fecha_nacimiento ASC", Jugador.class)
                    .getResultList();
        } catch(Exception e) {
            return new ArrayList<Jugador>();
        }
    }

    public List<Jugador> jugadoresPorColoniaYVideojuegos(String colonia) {
        try {
            return em.createQuery("SELECT j FROM Jugador j WHERE j.id_direccion.colonia = :col AND SIZE(j.id_videojuego) > 1", Jugador.class)
                    .setParameter("col", colonia)
                    .getResultList();
        } catch(Exception e) {
            return new ArrayList<Jugador>();
        }
    }
}
