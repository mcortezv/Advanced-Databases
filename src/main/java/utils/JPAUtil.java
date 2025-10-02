/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;
import jakarta.persistence.*;

/**
 *
 * @author Laboratorios
 */
public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "SuperHeroePU";
    private static EntityManagerFactory emf;

    public JPAUtil(){}

    public static EntityManager getEntityManager(){
        if (emf != null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf.createEntityManager();
    }

}
