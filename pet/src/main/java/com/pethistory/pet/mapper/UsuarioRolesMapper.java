package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.UsuarioRolesDto;
import com.pethistory.pet.models.UsuarioRoles;

@Component
public interface UsuarioRolesMapper {
    UsuarioRoles toUsuarioRoles(UsuarioRolesDto usuarioRolesDto);
    UsuarioRolesDto toUsuarioRolesDto(UsuarioRoles usuarioRoles);
}
