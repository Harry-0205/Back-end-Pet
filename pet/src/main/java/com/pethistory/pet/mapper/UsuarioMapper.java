package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.DtoUsuario;
import com.pethistory.pet.models.Usuario;

public interface UsuarioMapper {
    Usuario toUsuario(DtoUsuario dtoUsuario);
    DtoUsuario toDtoUsuario(Usuario usuario);
}
