package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RazaDto {

    private Long idRaza;
    @NotNull
    private String raza;
    @NotNull
    private Long idEspecie;

}
