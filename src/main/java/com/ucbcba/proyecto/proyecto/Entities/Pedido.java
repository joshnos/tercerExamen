package com.ucbcba.proyecto.proyecto.Entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class  Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @NotNull
    private int precio;
    @NotNull
    private String direccion;
    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    @ManyToOne
    private Empresa empresa;
    @ManyToMany
    @JoinTable(name = "pedido_option", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<Option> options;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
