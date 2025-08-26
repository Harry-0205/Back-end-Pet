package com.pethistory.pet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VeterinariasDto {
    private Long idVeterinaria;
    private String nombre;
    private String mail;
    private String fotico;
    private String direccion;

}
