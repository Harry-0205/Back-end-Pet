package com.pethistory.pet.dtos;

import lombok.Data;

@Data
public class DtoUsuarioUpdate {
    private Long numDoc;

    private String nombre;

    private String apeUno;

    private String apeDos;
    
    private Long telefono;

    private String direccion;

    private String correo;

    private byte [] contraseña;
}
