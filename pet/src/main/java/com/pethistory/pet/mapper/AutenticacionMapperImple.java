package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.RespuestaInicioSesionDto;
import com.pethistory.pet.models.UsuarioRoles;

@Component
public class AutenticacionMapperImple implements AutenticacionMapper {
    @Override
    public RespuestaInicioSesionDto aRespuestaInicioSesionDto(UsuarioRoles usuarioRoles, String token) {
        RespuestaInicioSesionDto respuesta = new RespuestaInicioSesionDto();
        respuesta.setToken(token);
        respuesta.setNomUsu(usuarioRoles.getUsuario().getCuenta().getCorreo());
        respuesta.setRol(usuarioRoles.getRol().getNomRol());

        return respuesta;
    }
}
