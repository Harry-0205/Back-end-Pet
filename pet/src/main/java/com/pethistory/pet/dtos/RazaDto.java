package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RazaDto {

    private Long idRaza;
    @NotNull
    private String raza;
    @NotNull
    private Long idEspecie;
    private String nomEspecie;

}
