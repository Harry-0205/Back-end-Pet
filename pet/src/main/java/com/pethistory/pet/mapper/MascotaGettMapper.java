package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.DtoMascota;
import com.pethistory.pet.models.Mascota;

public interface MascotaGettMapper {
    Mascota toMascota (DtoMascota dtoMascota);
    DtoMascota toDtoMascota(Mascota mascota);




}
