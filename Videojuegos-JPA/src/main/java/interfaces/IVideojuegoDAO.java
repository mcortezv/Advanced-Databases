/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import entities.Videojuego;

import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IVideojuegoDAO {

    boolean agregar(Videojuego videojuego);

    boolean editar(Videojuego videojuego);

    boolean eliminar(Long id);

    Videojuego buscarPorId(Long id);

    List<Videojuego> obtenerTodos();

    List<Videojuego> bucarPorNombre(String nombre);

    List<Videojuego> buscarPorDesarrolladora(String desarrolladora);

    List<Videojuego> filtrarPorPuntajeMayorA(int puntajeMinimo);

    List<Videojuego> ordenarPorNombre();

    List<Videojuego> ordenarPorPuntajeDesc();

    List<Object[]> contarVideojuegosPorDesarrolladora();

    List<Videojuego> buscarSinJugadores();

    List<Videojuego> buscarConLogrosMayorA(int puntajeMimino);

    int actualizarPuntajePorNombre(String nombre, int nuevoPuntaje);
}
