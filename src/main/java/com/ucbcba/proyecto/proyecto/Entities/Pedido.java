package com.ucbcba.proyecto.proyecto.Entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @NotNull
    private int precio;
    @NotNull
    private int  cantidad;
    @NotNull
    private String direccion;

    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    @ManyToOne
    private Empresa empresa;
    @NotNull
    @ManyToOne
    private Option option;


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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
