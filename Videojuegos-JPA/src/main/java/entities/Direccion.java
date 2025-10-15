/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;
import jakarta.persistence.*;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table (name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String colonia;
    private String numero;

    public Direccion() {
    }

    public Direccion(Long id_direccion, String calle, String colonia, String numero) {
        this.id = id_direccion;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_direccion) {
        this.id = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id_direccion=" + id +
                ", calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
