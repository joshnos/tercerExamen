package com.ucbcba.proyecto.proyecto.Entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Opcion_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdOpcionPedido;


    @NotNull
    @ManyToOne
    private Pedido pedido;
    @NotNull
    @ManyToOne
    private Option option;
    @NotNull
    private int Cantidad;


    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public void setIdOpcionPedido(int idOpcionPedido) {
        IdOpcionPedido = idOpcionPedido;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Option getOption() {
        return option;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Integer getIdOpcionPedido() {
        return IdOpcionPedido;
    }

    public void setIdOpcionPedido(Integer idOpcionPedido) {
        IdOpcionPedido = idOpcionPedido;
    }
}
