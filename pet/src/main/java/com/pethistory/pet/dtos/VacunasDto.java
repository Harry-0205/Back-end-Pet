package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VacunasDto {

    private Long idVacuna;
    @NotNull
    private String vacuna;
    @NotNull
    private Long costo;

    @NotNull
    @Size(min = 3, max = 255)
    private String dosis;
    @NotNull
    private String duracion;
    @NotNull
    private Long idEspecie;
    private String nomEspecie;
}
