package com.pethistory.pet.dtos;

import lombok.Data;

@Data
public class DtoUsuarioAsignacionVet {
    private Long idDocumento;
    private String nom;
    private Long idRol;
    private String nomRol;
    private Long idVeterinaria;
    private String nomVet;
    private String estado;
    private String mensaje;
}
