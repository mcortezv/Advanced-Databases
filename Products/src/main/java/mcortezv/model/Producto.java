package mcortezv.model;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.List;

public class Producto {
    @BsonId
    private ObjectId _id;    private String nombre;
    private double precio;
    private Long stock;
    private Proveedor proveedor;
    private List<String> categorias;
    @BsonProperty("creado_en")
    private Instant createdAt;
    @BsonProperty("actualizado_en")
    private Instant updatedAt;

    public Producto() {
    }

    @BsonCreator
    public Producto(
            @BsonProperty("_id") ObjectId _id,
            @BsonProperty("nombre") String nombre,
            @BsonProperty("precio") double precio,
            @BsonProperty("stock") Long stock,
            @BsonProperty("proveedor") Proveedor proveedor,
            @BsonProperty("categorias") List<String> categorias
    ) {
        this._id = _id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
        this.categorias = categorias;
    }


    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", proveedor=" + proveedor +
                ", categorias=" + categorias +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
