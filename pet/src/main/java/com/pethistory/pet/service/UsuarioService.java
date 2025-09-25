package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.dtos.DtoUsuarioUpdate;

public interface UsuarioService {
    DtoUsuario crear(DtoUsuario dtoUsuario);
    DtoUsuario buscarIdAll(Long id);
    DtoUsuarioGett buscarId(Long id);
    List<DtoUsuarioGett> listar();
    DtoUsuario update(DtoUsuarioUpdate dtoUsuarioUpdate);
}
