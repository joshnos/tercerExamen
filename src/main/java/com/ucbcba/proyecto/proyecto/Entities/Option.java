package com.ucbcba.proyecto.proyecto.Entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String name;

    @NotNull
    @Range(min=1,max=200, message = "Debe tener un valor entre 1 y 200")
    private int price;

    private String image;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "option")
    private Set<Opcion_Pedido> opcion_pedidos = new HashSet<>();

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setOpcion_pedidos(Set<Opcion_Pedido> opcion_pedidos) {
        this.opcion_pedidos = opcion_pedidos;
    }

    public Set<Opcion_Pedido> getOpcion_pedidos() {
        return opcion_pedidos;
    }
}