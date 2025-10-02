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
@Table (name = "Superheroe")
public class SuperHeroe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private String universo;

    @Embedded
    private String identidadSecreta;

    @Transient
    private String fraseIconica;

    public SuperHeroe(){}

    public SuperHeroe(Long id, String nombre, String universo,
                      String identidadSecreta, String fraseIconica){
        this.id = id;
        this.nombre = nombre;
        this.universo = universo;
        this.identidadSecreta = identidadSecreta;
        this.fraseIconica = identidadSecreta;
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

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public String getUnidadSecreta() {
        return unidadSecreta;
    }

    public void setUnidadSecreta(String unidadSecreta) {
        this.unidadSecreta = unidadSecreta;
    }

    public String getFraseIconica() {
        return fraseIconica;
    }

    public void setFraseIconica(String fraseIconica) {
        this.fraseIconica = fraseIconica;
    }
}
