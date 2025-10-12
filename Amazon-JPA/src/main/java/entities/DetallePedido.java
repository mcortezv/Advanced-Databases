/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "num_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "cod_barras")
    private Producto producto;

    private int cantidad;

    @Transient
    private BigDecimal importe;

    private BigDecimal precioVenta;

    public DetallePedido() {
    }

    public DetallePedido(Long id, Pedido pedido, Producto producto, int cantidad, BigDecimal importe, BigDecimal precioVenta) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
}
