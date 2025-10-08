/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table (name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String nombre;

    @ManyToMany(mappedBy = "id_categoria")
    private Set<Libro> id_libro;

    public Categoria() {}

    public Categoria(Long id_categoria, String nombre, Set<Libro> id_libro) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.id_libro = id_libro;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getId_libro() {
        return id_libro;
    }

    public void setId_libro(Set<Libro> id_libro) {
        this.id_libro = id_libro;
    }
}
