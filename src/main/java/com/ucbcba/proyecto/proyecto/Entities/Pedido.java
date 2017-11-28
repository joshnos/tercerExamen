package com.ucbcba.proyecto.proyecto.Entities;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class  Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @NotNull
    private int precio;

    @NotNull
    private String calle;

    @NotNull
    @Range(min = 0,message = "no puede ser vacio")
    private int numeroCasa;

    @Range(min = 0, max = 99999,message = "debe tener entre 1 y 5 digitos")
    private int zipCode;

    @ManyToOne
    private Zona zona;

    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    @ManyToOne
    private Empresa empresa;
    @NotNull
    @OneToMany(mappedBy = "pedido")
    private Set<Opcion_Pedido> opcion_pedidos = new HashSet<>();

    private boolean Estado;

    public Pedido(){
        Estado=true;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public boolean getEstado(){
        return Estado;
    }

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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }


    public Zona getZona() {
        return zona;
    }
}
