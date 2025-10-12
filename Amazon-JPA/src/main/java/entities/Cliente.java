/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_cliente")
    private Long numCliente;

    @ElementCollection
    @CollectionTable(name = "correos", joinColumns = @JoinColumn(name = "cliente_id"))
    private Set<String> correos;

    @ElementCollection
    @CollectionTable(name = "telefonos", joinColumns = @JoinColumn(name = "cliente_id"))
    private Set<String> telefonos;

    @Column(name = "fch_nac")
    private LocalDate fchNac;

    @Transient
    private int edad;

    private String nombre;

    @Column(name = "ap_paterno")
    private String apPaterno;

    @Column(name = "ap_materno")
    private String apMaterno;

    public Cliente() {
    }

    public Cliente(Long numCliente, Set<String> correos, Set<String> telefonos, LocalDate fchNac, int edad, String nombre, String apPaterno, String apMaterno) {
        this.numCliente = numCliente;
        this.correos = correos;
        this.telefonos = telefonos;
        this.fchNac = fchNac;
        this.edad = edad;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public Long getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(Long numCliente) {
        this.numCliente = numCliente;
    }

    public Set<String> getCorreos() {
        return correos;
    }

    public void setCorreos(Set<String> correos) {
        this.correos = correos;
    }

    public Set<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<String> telefonos) {
        this.telefonos = telefonos;
    }

    public LocalDate getFchNac() {
        return fchNac;
    }

    public void setFchNac(LocalDate fchNac) {
        this.fchNac = fchNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
}
