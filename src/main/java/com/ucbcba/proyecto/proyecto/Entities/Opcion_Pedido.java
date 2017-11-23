package com.ucbcba.proyecto.proyecto.Entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Opcion_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "Id_Pedido")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "Id_Opcion")
    private Option option;

    private Integer cantidad;

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdOpcionPedido(int id) {
        Id = id;
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

    public int getIdOpcionPedido() {
        return Id;
    }

}
