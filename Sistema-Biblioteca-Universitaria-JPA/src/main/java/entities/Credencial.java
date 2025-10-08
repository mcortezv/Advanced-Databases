/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Cortez, Manuel;
 */
@Entity
@Table (name = "credencial")
public class Credencial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_credencial;
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    public Credencial() {
    }

    public Credencial(Long id_credencial, String username, String password, Usuario usuario_id) {
        this.id_credencial = id_credencial;
        this.username = username;
        this.password = password;
        this.id_usuario = usuario_id;
    }

    public Long getId_credencial() {
        return id_credencial;
    }

    public void setId_credencial(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario usuario_id) {
        this.id_usuario = usuario_id;
    }
}
