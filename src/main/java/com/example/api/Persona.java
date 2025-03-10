package com.example.api;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
public class Persona extends PanacheEntityBase {
    @Id
    private Long id;
    private String nombre;
    private Integer edad;
    
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}