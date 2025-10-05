/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.persistence.*;

/**
 *
 * @author Laboratorios
 */

@Entity
@Table (name = "superheroes")
public class SuperHeroe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private models.Universo universo;

    @Embedded
    private IdentidadSecreta identidadSecreta;

    @Transient
    private String fraseIconica;

    public SuperHeroe(){}

    public SuperHeroe(String nombre, Universo universo,
                      IdentidadSecreta identidadSecreta, String fraseIconica){
        this.id = id;
        this.nombre = nombre;
        this.universo = universo;
        this.identidadSecreta = identidadSecreta;
        this.fraseIconica = fraseIconica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universo getUniverso() {
        return universo;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    public IdentidadSecreta getIdentidadSecreta() {
        return identidadSecreta;
    }

    public void setIdentidadSecreta(IdentidadSecreta identidadSecreta) {
        this.identidadSecreta = identidadSecreta;
    }

    public String getFraseIconica() {
        return fraseIconica;
    }

    public void setFraseIconica(String fraseIconica) {
        this.fraseIconica = fraseIconica;
    }

    @Override
    public String toString(){
        return String.format("ID: %d \nNombre: %s \nUniverso: %s \nIdentidad Secreta: %s \nFrase Iconica: %s", this.getId(), this.getNombre(), this.getUniverso(), this.getIdentidadSecreta(), this.getFraseIconica());
    }
}
