package com.pethistory.pet.service;

import com.pethistory.pet.dtos.DtoUsuario;

public interface UsuarioService {
    DtoUsuario crear(DtoUsuario dtoUsuario);
    DtoUsuario buscarIdAll(Long id);
}
