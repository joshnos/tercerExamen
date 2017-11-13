package com.ucbcba.proyecto.proyecto.Entities;

import javax.persistence.*;

@Entity
public class DatosPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int Nit;
    long telf;
    String nombreFactura;
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
        return nombreFactura;
    }

    public void setNombreFactura(String nombreFactura) {
        this.nombreFactura = nombreFactura;
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
