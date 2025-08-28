package com.pethistory.pet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;


@Getter
@Entity
@Table(name = "agendamiento")
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    @NotNull
    private Timestamp fecAg;
    @NotNull
    private Date fecAsi;


    @ManyToOne
    @JoinColumn(name = "id_procedimiento", nullable = false)
    private List<Procedimiento> procedimientos;


    @ManyToOne
    @JoinColumn(name = "id_veterinaria", nullable = false)
    private List<Veterinarias> veterinarias;


    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private List<Estado> Estados;
}
