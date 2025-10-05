/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.ISuperHeroeDAO;
import jakarta.persistence.EntityManager;
import models.SuperHeroe;
import utils.JPAUtil;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public class SuperHeroeDAO implements ISuperHeroeDAO {

    @Override
    public void insertar(SuperHeroe superHeroe) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(superHeroe);
            em.getTransaction().commit();
        } catch (Exception ex){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(SuperHeroe superHeroe) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(superHeroe);
            em.getTransaction().commit();
        } catch (Exception ex){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            SuperHeroe superHeroe = em.find(SuperHeroe.class, id);
            if (superHeroe != null){
                em.remove(superHeroe);
            }
            em.getTransaction().commit();
        } catch (Exception ex){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public SuperHeroe buscar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(SuperHeroe.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<SuperHeroe> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM SuperHeroe s", SuperHeroe.class).getResultList();
        } finally {
            em.close();
        }
    }
}
