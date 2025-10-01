package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class HistoriaClinicaDto {

    private Long id;

    @NotNull
    private Date fechaI;

    @NotNull
    private String anot;
    
    @NotNull
    private Long idMascta;
    
    private String nombreMascot;
}
