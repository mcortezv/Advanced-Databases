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
@Table(name = "pedidos")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_pedido")
    private Long numPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<DetallePedido> detallePedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "num_cliente")
    private Cliente cliente;

    @Transient
    private BigDecimal total;

    @Transient
    private BigDecimal subtotal;

    @Transient
    private BigDecimal iva;

    public Pedido() {
    }

    public Pedido(Long numPedido, Set<DetallePedido> detallePedido, Cliente cliente, BigDecimal total, BigDecimal subtotal, BigDecimal iva) {
        this.numPedido = numPedido;
        this.detallePedido = detallePedido;
        this.cliente = cliente;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
    }

    public Long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Long numPedido) {
        this.numPedido = numPedido;
    }

    public Set<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Set<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }
}
