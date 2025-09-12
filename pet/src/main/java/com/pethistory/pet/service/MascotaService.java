package com.pethistory.pet.service;

import com.pethistory.pet.dtos.DtoMascota;

public interface MascotaService {

    DtoMascota crear(DtoMascota dtoMascota);
    DtoMascota buscarIdAll(Long id);

}
