package com.ucbcba.proyecto.proyecto.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmpresa;

<<<<<<< HEAD
    /*@OneToOne
=======
   /* @OneToOne
>>>>>>> origin/master
    @JoinColumn(name="idUsuario")
    private Integer usuario_id;*/

    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String direccion;

    @NotNull
    private int telefono;

    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /*public Integer getUsuario_id() {
        return usuario_id;
    }*/

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /*public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }*/
}
