package main;
import DAO.*;
import entities.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class VideojuegosJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideojuegosPU");
        EntityManager em = emf.createEntityManager();

        try {
            DireccionDAO ddao = new DireccionDAO(em);
            VideojuegoDAO vdao = new VideojuegoDAO(em);
            JugadorDAO jdao = new JugadorDAO(em);
            LogroDAO ldao = new LogroDAO(em);

            Direccion d1 = new Direccion();
            d1.setCalle("Miguel Hidalgo");
            d1.setColonia("San Jose");
            d1.setNumero("100");

            Direccion d2 = new Direccion();
            d2.setCalle("Bacum");
            d2.setColonia("Centro");
            d2.setNumero("200");

            ddao.agregar(d1);
            ddao.agregar(d2);

            Videojuego v1 = new Videojuego();
            v1.setNombre("Fortnite");
            v1.setDesarrolladora("Epic Games");
            v1.setPuntaje(170);

            Videojuego v2 = new Videojuego();
            v2.setNombre("CS:GO");
            v2.setDesarrolladora("Valve");
            v2.setPuntaje(95);

            Videojuego v3 = new Videojuego();
            v3.setNombre("Rocket League");
            v3.setDesarrolladora("Epic Games");
            v3.setPuntaje(120);

            vdao.agregar(v1);
            vdao.agregar(v2);
            vdao.agregar(v3);

            Jugador j1 = new Jugador();
            j1.setPseudonimo("Fire");
            j1.setSexo("Masculino");
            j1.setFecha_nacimiento(LocalDate.of(2005,2,13));
            j1.setId_direccion(d1);

            Jugador j2 = new Jugador();
            j2.setPseudonimo("Shadow");
            j2.setSexo("Femenino");
            j2.setFecha_nacimiento(LocalDate.of(2003,5,20));
            j2.setId_direccion(d2);

            Jugador j3 = new Jugador();
            j3.setPseudonimo("Blaze");
            j3.setSexo("Masculino");
            j3.setFecha_nacimiento(LocalDate.of(2000,7,11));
            j3.setId_direccion(d1);

            jdao.agregar(j1);
            jdao.agregar(j2);
            jdao.agregar(j3);

            v1.setId_jugador(new HashSet<Jugador>(Arrays.asList(j1,j3)));
            v2.setId_jugador(new HashSet<Jugador>(Arrays.asList(j2,j3)));
            v3.setId_jugador(new HashSet<Jugador>(Arrays.asList(j1,j3)));

            vdao.editar(v1);
            vdao.editar(v2);
            vdao.editar(v3);

            j1.setId_videojuego(new HashSet<Videojuego>(Arrays.asList(v1,v3)));
            j2.setId_videojuego(new HashSet<Videojuego>(Arrays.asList(v2)));
            j3.setId_videojuego(new HashSet<Videojuego>(Arrays.asList(v1,v2,v3)));

            jdao.editar(j1);
            jdao.editar(j2);
            jdao.editar(j3);

            Logro l1 = new Logro();
            l1.setNombre("Ganar una Partida");
            l1.setPuntos(100);
            l1.setId_videojuego(v1);

            Logro l2 = new Logro();
            l2.setNombre("Campeón del Mes");
            l2.setPuntos(150);
            l2.setId_videojuego(v1);

            Logro l3 = new Logro();
            l3.setNombre("100 Kills");
            l3.setPuntos(80);
            l3.setId_videojuego(v2);

            Logro l4 = new Logro();
            l4.setNombre("Logro Supremo");
            l4.setPuntos(200);
            l4.setId_videojuego(v3);

            ldao.agregar(l1);
            ldao.agregar(l2);
            ldao.agregar(l3);
            ldao.agregar(l4);

            System.out.println("Videojuegos con mayor numero de logros:");
            List<Object[]> videojuegos = vdao.contarVideojuegosPorDesarrolladora();
            for(Object[] row : videojuegos){
                System.out.println(row[0] + " - " + row[1]);
            }

            System.out.println("\nJugadores con mas videojuegos:");
            List<Object[]> jugadores = jdao.jugadoresConMasVideojuegos();
            for(Object[] row : jugadores){
                System.out.println(row[0] + " - " + row[1]);
            }

            System.out.println("\nLogros mayores al promedio:");
            List<Logro> logrosPromedio = ldao.logrosMayoresAlPromedio();
            for(Logro l : logrosPromedio){
                System.out.println(l.getNombre() + " - " + l.getPuntos());
            }

            System.out.println("\nJugadores ordenados por edad (mayor a menor):");
            List<Jugador> jugadoresEdad = jdao.jugadoresOrdenadosPorEdadDesc();
            for(Jugador j : jugadoresEdad){
                System.out.println(j.getPseudonimo() + " - " + j.getFecha_nacimiento());
            }

            System.out.println("\nLogro mas alto:");
            Logro max = ldao.logroMasAlto();
            System.out.println(max != null ? max.getNombre() + " - " + max.getPuntos() : "Ninguno");

        } catch(Exception ex) {
            ex.printStackTrace();
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
