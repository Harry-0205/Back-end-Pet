package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MascotaCreateDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private Date fecNam;

    private String foto;

    @NotBlank
    private String color;

    @NotBlank
    private Long usuarioDoc;

    @NotBlank
    private String raza;


}

