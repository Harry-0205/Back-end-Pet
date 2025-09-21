package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MascotaUpdateDto {

    @NotNull
    private Long idMasc;

    @NotNull
    @Size(min = 3, max = 50)
    private String nom;

    @NotNull
    private Date fecNam;

    @NotNull
    @Size(min = 3, max = 255)
    private String foto;

}
