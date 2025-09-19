package com.pethistory.pet.service;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.dtos.DtoMascotaAll;
import com.pethistory.pet.dtos.MascotaCreateDto;
import com.pethistory.pet.dtos.MascotaUpdateDto;

public interface MascotaService {
    DtoMascota guardar (MascotaCreateDto dto);
    DtoMascota crear(DtoMascota dtoMascota);
    DtoMascota buscarIdAll(Long id);
    DtoMascotaAll buscarId(Long id);
    DtoMascota actualizarMascota(MascotaUpdateDto dto);

}
