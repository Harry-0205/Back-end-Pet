package com.pethistory.pet.dtos;

import java.sql.Date;
import java.util.List;

import com.pethistory.pet.models.Rol;
import com.pethistory.pet.models.TipoDoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoUsuario {
    private Long numDoc;
    private String nombre;
    private String apeUno;
    private String apeDos;
    private String telefono;
    private Integer numContra;
    private String direccion;
    private String email;
    private Date fechaNac;
    private TipoDoc tipoDoc;
    private List<Rol> rols;
}
