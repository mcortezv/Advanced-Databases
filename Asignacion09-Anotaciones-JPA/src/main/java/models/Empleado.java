/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author Cotez, Manuel;
 */
@Entity
@Table(name = "empleados")
public class Empleado {

    public enum Estatus {
        ACTIVO, INACTIVO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Double salario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estatus estatus;

    @Column(nullable = false)
    private LocalDate fechaContratacion;

    public Empleado() {}

    public Empleado(String nombre, String email, Double salario, Estatus estatus, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.estatus = estatus;
        this.fechaContratacion = fechaContratacion;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public Estatus getEstatus() { return estatus; }
    public void setEstatus(Estatus estatus) { this.estatus = estatus; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                ", estatus=" + estatus +
                ", fechaContratacion=" + fechaContratacion +
                '}';
    }
}
