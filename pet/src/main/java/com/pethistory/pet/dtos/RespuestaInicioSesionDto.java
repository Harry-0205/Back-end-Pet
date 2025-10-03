package com.pethistory.pet.dtos;

import lombok.Data;

@Data
public class RespuestaInicioSesionDto {
    private String token;
    private String nomUsu;
    private String rol;

}
