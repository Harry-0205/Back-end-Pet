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

    @NotNull
    private Long idCita;

    @NotNull
    private Date fecAg;

    @NotNull
    private Date fecAsi;

    @NotNull
    private Long idProcedimientos;
    
    @NotNull
    private String procedimientos;

    @NotNull
    private Long idVeterinarias;

    @NotNull
    private String nomVet;
    
    @NotNull
    private Boolean estado;
}
