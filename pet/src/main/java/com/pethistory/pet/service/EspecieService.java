package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.EspecieDto;

public interface EspecieService {
    EspecieDto buscarIdAll(Long id);
    List<EspecieDto> listarTodos();

}
