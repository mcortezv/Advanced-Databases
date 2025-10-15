/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table (name = "Jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha_nacimiento;

    @Transient
    private int edad;

    @OneToOne
    @JoinColumn(name = "id_direccion")
    private Direccion id_direccion;

    private String pseudonimo;
    private String sexo;

    @ManyToMany(mappedBy = "id_jugador")
    private Set<Videojuego> id_videojuego;

    public Jugador() {
    }

    public Jugador(Long id_jugador, LocalDate fecha_nacimiento, int edad, Direccion id_direccion, String pseudonimo, String sexo, Set<Videojuego> id_videojuego) {
        this.id = id_jugador;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.id_direccion = id_direccion;
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        this.id_videojuego = id_videojuego;
        this.edad = LocalDate.now().getYear() - fecha_nacimiento.getYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_jugador) {
        this.id = id_jugador;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<Videojuego> getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(Set<Videojuego> id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id_jugador=" + id +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", edad=" + edad +
                ", id_direccion=" + id_direccion +
                ", pseudonimo='" + pseudonimo + '\'' +
                ", sexo='" + sexo + '\'' +
                ", id_videojuego=" + id_videojuego +
                '}';
    }
}
