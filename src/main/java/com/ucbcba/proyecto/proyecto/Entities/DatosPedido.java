package com.ucbcba.proyecto.proyecto.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DatosPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int Nit;
    @NotNull
    long telf;
    @NotNull
    @Size(min = 1, max = 200, message = "Debe tener entre 1 y 45 caracteres")
    String razonSocial;
    String direccion;
    @ManyToOne
    Pedido pedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNit() {
        return Nit;
    }

    public void setNit(int nit) {
        Nit = nit;
    }

    public long getTelf() {
        return telf;
    }

    public void setTelf(long telf) {
        this.telf = telf;
    }

    public String getNombreFactura() {
        return razonSocial;
    }

    public void setNombreFactura(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
