package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.EspecieDto;
import com.pethistory.pet.models.Especie;

public interface EspecieMapper {
    Especie toEspecie(EspecieDto especieDto);
    EspecieDto toEspecieDto(Especie especie);

}
