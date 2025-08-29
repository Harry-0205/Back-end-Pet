package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoDto {

    @NotNull
    private Long idEstado;

    @NotNull
    private Boolean realizado;
    @NotNull
    private Boolean cancelado;

}
