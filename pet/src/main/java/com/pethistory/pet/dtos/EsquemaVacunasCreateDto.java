package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EsquemaVacunasCreateDto {

    @NotNull
    @Size(min = 3, max = 255)
    private String dos;

    @NotNull
    private Date fecVacu;

    @NotNull
    private Long idMascota;

    @NotNull
    private Long idVacuna;

    @NotNull
    private Long usuarioDoc;
}
