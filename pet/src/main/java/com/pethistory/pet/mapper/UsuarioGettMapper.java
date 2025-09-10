package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.DtoUsuarioGett;
import com.pethistory.pet.models.Usuario;

public interface UsuarioGettMapper {
    Usuario toUsuario (DtoUsuarioGett dtoUsuarioGett);
    DtoUsuarioGett toDtoUsuarioGett (Usuario usuario);
}
