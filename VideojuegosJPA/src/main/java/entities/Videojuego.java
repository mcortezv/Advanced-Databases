/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;
import jakarta.persistence.*;
import java.util.Set;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table (name = "videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_videojuego;
    private int puntaje;
    private String desarrolladora;
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "videojuego_jugador", joinColumns = @JoinColumn(name = "id_videojuego"),
            inverseJoinColumns = @JoinColumn(name = "id_jugador"))
    private Set<Jugador> id_jugador;

    public Videojuego() {
    }

    public Videojuego(Set<Jugador> id_jugador, String nombre, String desarrolladora, int puntaje, Long id_videojuego) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.puntaje = puntaje;
        this.id_videojuego = id_videojuego;
    }

    public Long getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(Long id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Jugador> getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Set<Jugador> id_jugador) {
        this.id_jugador = id_jugador;
    }
}
