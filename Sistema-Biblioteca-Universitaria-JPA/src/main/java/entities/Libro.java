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
@Table (name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_libro;
    private String titulo;
    private Long anio_publicacion;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor id_autor;

    @ManyToMany
    @JoinTable(name = "libro_categoria", joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> id_categoria;

    public Libro() {
    }

    public Libro(Long id_libro, String titulo, Long anio_publicacion, Autor id_autor, Set<Categoria> id_categoria) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.anio_publicacion = anio_publicacion;
        this.id_autor = id_autor;
        this.id_categoria = id_categoria;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(Long anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public Autor getId_autor() {
        return id_autor;
    }

    public void setId_autor(Autor id_autor) {
        this.id_autor = id_autor;
    }

    public Set<Categoria> getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Set<Categoria> id_categoria) {
        this.id_categoria = id_categoria;
    }
}
