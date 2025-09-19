package com.pethistory.pet.service;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioGett;

public interface UsuarioService {
    DtoUsuario crear(DtoUsuario dtoUsuario);
    DtoUsuario buscarIdAll(Long id);
    DtoUsuarioGett buscarId(Long id);
}
