/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;
import jakarta.persistence.*;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table(name = "logro")
public class Logro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int puntos;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_videojuego")
    private Videojuego id_videojuego;

    public Logro() {
    }

    public Logro(Videojuego id_videojuego, String nombre, int puntos, Long id_logro) {
        this.id_videojuego = id_videojuego;
        this.nombre = nombre;
        this.puntos = puntos;
        this.id = id_logro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_logro) {
        this.id = id_logro;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Videojuego getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(Videojuego id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    @Override
    public String toString() {
        return "Logro{" +
                "id_logro=" + id +
                ", puntos=" + puntos +
                ", nombre='" + nombre + '\'' +
                ", id_videojuego=" + id_videojuego +
                '}';
    }
}
