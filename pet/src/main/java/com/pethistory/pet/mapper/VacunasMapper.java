package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.VacunasDto;
import com.pethistory.pet.models.Vacunas;

public interface VacunasMapper {
    Vacunas toVacunas(VacunasDto vacunasDto);
    VacunasDto toVacunasDto(Vacunas vacunas);
}
