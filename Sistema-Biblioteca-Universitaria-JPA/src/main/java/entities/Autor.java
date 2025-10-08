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
@Table (name = "autor")
public class Autor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_autor;
    private String nombre;
    private String nacionalidad;

    @OneToMany(mappedBy = "id_autor")
    private Set<Libro> id_libro;

    public Autor() {
    }

    public Autor(long id_autor, String nombre, String nacionalidad, Set<Libro> id_libro) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.id_libro = id_libro;
    }

    public long getId_autor() {
        return id_autor;
    }

    public void setId_autor(long id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Set<Libro> getId_libro() {
        return id_libro;
    }

    public void setId_libro(Set<Libro> id_libro) {
        this.id_libro = id_libro;
    }
}
