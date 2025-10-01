package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamientoDto {

    private Long idCita;

    @NotNull
    private Date fecAg;

    @NotNull
    private Date fecAsi;

    @NotNull
    private Long idMascota;

    private String nomMasc;
    

    private Long idProcedimientos;

    @NotNull
    private String procedimientos;

    private Long idVeterinarias;

    @NotNull
    private String nomVet;

    private Boolean estado;
}
