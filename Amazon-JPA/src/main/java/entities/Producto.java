/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import jakarta.persistence.*;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_barras")
    private Long codBarras;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<DetallePedido> detallePedidos;

    private BigDecimal precio;

    private String descripcion;

    private int stock;

    public Producto() {
    }

    public Producto(Long codBarras, Set<DetallePedido> detallePedidos, BigDecimal precio, String descripcion, int stock) {
        this.codBarras = codBarras;
        this.detallePedidos = detallePedidos;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public Long getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Long codBarras) {
        this.codBarras = codBarras;
    }

    public Set<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(Set<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
