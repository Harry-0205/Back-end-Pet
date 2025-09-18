package com.pethistory.pet.service;

import com.pethistory.pet.dtos.VacunasDto;

public interface VacunasService {
    VacunasDto crear(VacunasDto vacunasDto);
    VacunasDto buscarIdAll(Long id);
}
