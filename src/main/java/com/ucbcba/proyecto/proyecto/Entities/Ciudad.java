package com.ucbcba.proyecto.proyecto.Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCiudad;

    @NotNull
    private String name;

    public Integer getIdCiudad() {
        return idCiudad;
    }

    @OneToMany (mappedBy = "ciudad")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
