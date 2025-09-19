package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.models.Raza;

public interface RazaMapper {
    Raza toRaza(RazaDto razaDto);
    RazaDto toRazaDto(Raza raza);

}
