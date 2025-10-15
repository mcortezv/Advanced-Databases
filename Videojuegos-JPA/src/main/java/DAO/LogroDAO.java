package DAO;
import entities.Logro;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class LogroDAO {
    private EntityManager em;

    public LogroDAO(EntityManager em) {
        this.em = em;
    }

    public boolean agregar(Logro l) {
        try {
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public boolean editar(Logro l) {
        try {
            em.getTransaction().begin();
            em.merge(l);
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
            Logro l = em.find(Logro.class, id);
            if(l != null) em.remove(l);
            em.getTransaction().commit();
            return l != null;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public Logro buscarPorId(Long id) {
        return em.find(Logro.class, id);
    }

    public List<Logro> obtenerTodos() {
        try {
            return em.createQuery("SELECT l FROM Logro l", Logro.class).getResultList();
        } catch(Exception e) {
            return new ArrayList<Logro>();
        }
    }

    public List<Logro> logrosMayoresAlPromedio() {
        try {
            return em.createQuery("SELECT l FROM Logro l WHERE l.puntos > (SELECT AVG(l2.puntos) FROM Logro l2)", Logro.class)
                    .getResultList();
        } catch(Exception e) {
            return new ArrayList<Logro>();
        }
    }

    public Logro logroMasAlto() {
        try {
            return em.createQuery("SELECT l FROM Logro l ORDER BY l.puntos DESC", Logro.class)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }
}
