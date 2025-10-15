package DAO;
import entities.Direccion;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class DireccionDAO {
    private EntityManager em;

    public DireccionDAO(EntityManager em) {
        this.em = em;
    }

    public boolean agregar(Direccion d) {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public boolean editar(Direccion d) {
        try {
            em.getTransaction().begin();
            em.merge(d);
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
            Direccion d = em.find(Direccion.class, id);
            if(d != null) em.remove(d);
            em.getTransaction().commit();
            return d != null;
        } catch(Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            return false;
        }
    }

    public Direccion buscarPorId(Long id) {
        return em.find(Direccion.class, id);
    }

    public List<Direccion> obtenerTodas() {
        try {
            return em.createQuery("SELECT d FROM Direccion d", Direccion.class).getResultList();
        } catch(Exception e) {
            return new ArrayList<Direccion>();
        }
    }
}
