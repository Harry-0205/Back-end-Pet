package com.pethistory.pet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;




@Getter
@Entity
@Table(name = "veterinaria")
public class Veterinarias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idVeterinaria;

    @NotNull
    private String nombre;
    @NotNull
    private String direccion;
    @NotNull
    private String telefono;


    @OneToMany(mappedBy = "veterinaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Agendamiento agendamientos;
}
