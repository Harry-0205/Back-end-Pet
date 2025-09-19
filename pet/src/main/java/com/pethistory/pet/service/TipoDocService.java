package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.TipoDocDto;

public interface TipoDocService {
    TipoDocDto buscarIdAll(Long id);
    List<TipoDocDto> listarTodos();
}
