package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.UsuarioRolesDto;

public interface UsuarioRolesServ {
    UsuarioRolesDto crear (UsuarioRolesDto usuarioRolesDto);
    List<UsuarioRolesDto> listarUsuarios(Long idDoc);
    List<UsuarioRolesDto> listarRol(Long idRol);
}
