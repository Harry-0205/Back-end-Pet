package com.pethistory.pet.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoUsuario {

    @NotNull
    private Long numDoc;

    @NotNull
    @Size(min = 3, max = 20)
    private String nombre;

    @NotNull
    @Size(min = 3, max = 20)
    private String apeUno;

    @Size(min = 3, max = 20)
    private String apeDos;

    @NotNull
    private Long telefono;

    private Long numContra;

    @NotNull
    @Size(min = 3, max = 50)
    private String direccion;

    @NotNull
    private Date fechaNac;

    @NotNull
    private Long tipdoc;

    private String nomTipoDoc;

    @NotNull
    @Size(min = 3, max = 100)
    private String correo;

    @NotNull
    private byte [] passw;
}
