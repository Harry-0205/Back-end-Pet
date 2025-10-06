package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.dtos.DtoMascotaAll;
import com.pethistory.pet.dtos.MascotaCreateDto;
import com.pethistory.pet.dtos.MascotaUpdateDto;

public interface MascotaService {
    DtoMascota guardar (DtoMascota dto);
    DtoMascota crear(DtoMascota dtoMascota);
    DtoMascota buscarIdAll(Long id);
    DtoMascotaAll buscarId(Long id);
    DtoMascota actualizarMascota(MascotaUpdateDto dto);
    List <DtoMascota> listartodos ();

}
