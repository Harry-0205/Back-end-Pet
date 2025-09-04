package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VeterinariasDto {
    @NotNull
    private Long idVeterinaria;
    @NotNull
    private String nombre;
    @NotNull
    private String mail;
    @NotNull
    private String fotico;
    @NotNull
    private String direccion;

}
