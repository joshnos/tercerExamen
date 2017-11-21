package com.ucbcba.proyecto.proyecto.Entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
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
    @NotNull
    @OneToMany(mappedBy = "pedido")
    private Set<Opcion_Pedido> opcion_pedidos = new HashSet<>();

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

    public void setOpcion_pedidos(Set<Opcion_Pedido> opcion_pedidos) {
        this.opcion_pedidos = opcion_pedidos;
    }

    public Set<Opcion_Pedido> getOpcion_pedidos() {
        return opcion_pedidos;
    }
}
