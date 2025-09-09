package com.pethistory.pet.service;

import com.pethistory.pet.dtos.DtoUsuarioGett;

public interface UsuarioGettService {
    DtoUsuarioGett buscarId(Long id);
}
