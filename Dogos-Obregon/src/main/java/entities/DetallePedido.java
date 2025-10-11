/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Cortez; Manuel;
 */
@Entity
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "hotdog_id")
    private HotDog hotDog;

    private int cantidad;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    private BigDecimal subTotal;

    public DetallePedido() {
    }

    public DetallePedido(BigDecimal subTotal, BigDecimal precioVenta, int cantidad, HotDog hotDog, Pedido pedido, Long id) {
        this.subTotal = subTotal;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.hotDog = hotDog;
        this.pedido = pedido;
        this.id = id;
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

    public HotDog getHotDog() {
        return hotDog;
    }

    public void setHotDog(HotDog hotDog) {
        this.hotDog = hotDog;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
