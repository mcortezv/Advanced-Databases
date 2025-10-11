/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author Cortez; Manuel;
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Column(name = "ap_paterno")
    private String apPaterno;
    
    @Column(name = "ap_materno")
    private String apMaterno;
    
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNac;

    @OneToOne
    @JoinColumn(name = "cliente_recomienda_id", referencedColumnName = "id")
    private Cliente clienteRecomienda;

    @ElementCollection
    @CollectionTable(name = "cliente_telefonos", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "telefono")
    private Set<String> telefonos;

    @ElementCollection
    @CollectionTable(name = "cliente_preferencias", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "preferencias")
    private Set<String> preferencias;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apPaterno, String apMaterno, LocalDate fechaNac, Cliente clienteRecomienda, Set<String> telefonos, Set<String> preferencias, Set<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNac = fechaNac;
        this.clienteRecomienda = clienteRecomienda;
        this.telefonos = telefonos;
        this.preferencias = preferencias;
        this.pedidos = pedidos;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Set<String> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Set<String> preferencias) {
        this.preferencias = preferencias;
    }

    public Set<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<String> telefonos) {
        this.telefonos = telefonos;
    }

    public Cliente getClienteRecomienda() {
        return clienteRecomienda;
    }

    public void setClienteRecomienda(Cliente clienteRecomienda) {
        this.clienteRecomienda = clienteRecomienda;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
