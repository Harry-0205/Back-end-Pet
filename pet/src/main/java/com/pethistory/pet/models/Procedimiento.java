package com.pethistory.pet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;




@Getter
@Entity
@Table(name = "procedimiento")
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcedimiento;

    @NotNull
    private String nombre;
    @NotNull
    private String descripcion;


    @OneToMany(mappedBy = "procedimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Agendamiento agendamientos;
}

