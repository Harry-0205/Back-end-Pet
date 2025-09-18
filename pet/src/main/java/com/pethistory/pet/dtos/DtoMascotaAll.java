package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DtoMascotaAll {
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

    @NotNull
    private long idColor;

    private String nomCol;

    @NotNull
    private Long usuarioDoc;

    private String nomUsu;

    @NotNull
    private Long idRaza;

    private String nomRaza;

    @NotNull
    private Boolean vivo;

}
