package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.RazaDto;

public interface RazaService {
    RazaDto buscarIdAll(Long id);
    List<RazaDto> listarTodos();
}
