package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RazaDto {

    @NotNull
    private Long idRaza;
    private String raza;
    
    @NotNull
    private Long idEspecie;
    private String nomEspecie;

}
