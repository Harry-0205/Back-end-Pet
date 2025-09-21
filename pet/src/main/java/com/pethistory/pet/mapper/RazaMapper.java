package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.models.Raza;

public interface RazaMapper {
    RazaDto toRazaDto(Raza raza);

}
