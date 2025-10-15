package DAO;
import entities.Videojuego;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class VideojuegoDAO {
    private EntityManager em;

    public VideojuegoDAO(EntityManager em) {
        this.em = em;
    }

    public boolean agregar(Videojuego v) {
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public boolean editar(Videojuego v) {
        try {
            em.getTransaction().begin();
            em.merge(v);
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
            Videojuego v = em.find(Videojuego.class, id);
            if(v != null) em.remove(v);
            em.getTransaction().commit();
            return v != null;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public Videojuego buscarPorId(Long id) {
        return em.find(Videojuego.class, id);
    }

    public List<Videojuego> obtenerTodos() {
        try {
            return em.createQuery("SELECT v FROM Videojuego v", Videojuego.class).getResultList();
        } catch(Exception e) {
            return new ArrayList<Videojuego>();
        }
    }

    public List<Object[]> contarVideojuegosPorDesarrolladora() {
        try {
            return em.createQuery("SELECT v.desarrolladora, COUNT(v) FROM Videojuego v GROUP BY v.desarrolladora", Object[].class)
                    .getResultList();
        } catch(Exception e) {
            return new ArrayList<Object[]>();
        }
    }
}
