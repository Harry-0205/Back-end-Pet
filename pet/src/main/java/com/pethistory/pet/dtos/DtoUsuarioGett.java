package com.pethistory.pet.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DtoUsuarioGett {
    private Long numDoc;

    private String nombre;

    private String apeUno;

    private String apeDos;

    private Long telefono;

    private Long numContra;

    private String direccion;

    private Date fechaNac;

    private Integer tipdoc;

    private String nomTipoDoc;

    private String correo;
}
