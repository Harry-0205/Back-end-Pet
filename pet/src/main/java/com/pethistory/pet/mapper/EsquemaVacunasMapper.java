package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.DtoEsquemaVacunas;
import com.pethistory.pet.dtos.EsquemaVacunasCreateDto;
import com.pethistory.pet.models.EsquemaVacunas;

public interface EsquemaVacunasMapper {

    EsquemaVacunas toEsquema(EsquemaVacunasCreateDto dto);

    DtoEsquemaVacunas toDto(EsquemaVacunas entity);

    void updateEntity(EsquemaVacunas entity, DtoEsquemaVacunas dto);
}
