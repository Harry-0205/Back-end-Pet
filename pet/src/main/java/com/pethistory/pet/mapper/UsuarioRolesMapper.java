package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.DtoUsuarioAsignacionVet;
import com.pethistory.pet.dtos.UsuarioRolesDto;
import com.pethistory.pet.models.UsuarioRoles;

public interface UsuarioRolesMapper {
    UsuarioRoles toUsuarioRoles(UsuarioRolesDto usuarioRolesDto);
    UsuarioRolesDto toUsuarioRolesDto(UsuarioRoles usuarioRoles);
    DtoUsuarioAsignacionVet toAsignacion(UsuarioRoles entity);
}
