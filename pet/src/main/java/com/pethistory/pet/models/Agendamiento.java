package com.pethistory.pet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "agendamiento")
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    @NotNull
    private Date fecAg;
    @NotNull
    private Date fecAsi;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mascota", foreignKey = @ForeignKey(name = "FK_mascota"))
    private Mascota mascota;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_procedimiento", foreignKey = @ForeignKey(name = "FK_procedimiento"))
    private Procedimiento procedimiento;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_veterinaria", foreignKey = @ForeignKey(name = "FK_veterinaria"))
    private Veterinarias veterinaria;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name = "FK_estado"))
    private Estado Estado;
}
