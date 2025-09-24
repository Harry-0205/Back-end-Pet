package com.pethistory.pet.dtos;

import lombok.Data;

@Data
public class DtoUsuarioAsignacionVet {
    private Long doc;
    private String nombreUsu;
    private Long idRol;
    private String nomRol;
    private Long numContra;
    private Long idVet;
    private String nomVet;
    private String estado;
    private String mensaje;
}
