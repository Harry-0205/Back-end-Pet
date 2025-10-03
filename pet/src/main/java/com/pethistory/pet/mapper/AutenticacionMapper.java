package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.RespuestaInicioSesionDto;
import com.pethistory.pet.models.UsuarioRoles;

public interface AutenticacionMapper {
    RespuestaInicioSesionDto aRespuestaInicioSesionDto(UsuarioRoles usuarioRoles, String token);

}
