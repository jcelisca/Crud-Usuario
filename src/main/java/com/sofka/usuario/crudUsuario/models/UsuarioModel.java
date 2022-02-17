package com.sofka.usuario.crudUsuario.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", length = 30)
    private String nombre = "user";

    @Column(name = "email")
    @Email
    private String email = "noemail@email.com";

    @Min(1)
    @Max(5)
    @Column(name = "prioridad")
    private Integer prioridad = 1;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

}
