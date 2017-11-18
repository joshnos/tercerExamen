package com.ucbcba.proyecto.proyecto.Entities;
;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmpresa;

    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String direccion;

    @Range(min = 1,max = 5,message = "El valor debe estar entre 1 y 5")
    private int calificacion;

    @NotNull
    private int telefono;
    
    private String image;


    @NotNull
    @Size(min = 1, max = 45, message = "Debe tener entre 1 y 45 caracteres")
    private String descripcion;

    @OneToMany(mappedBy = "empresa")
    private Set<Option> Options;

    public Set<Option> getOptions() {
        return Options;
    }

    public void setOptions(Set<Option> options) {
        Options = options;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
