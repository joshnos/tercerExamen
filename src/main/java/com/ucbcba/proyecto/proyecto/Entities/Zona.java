package com.ucbcba.proyecto.proyecto.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idZona;

    @NotNull
    private String nombre;

    @OneToMany (mappedBy = "zona")
    private Set<Pedido> pedidos;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
