package com.pethistory.pet.service;

import java.util.List;
import java.util.Map;

import com.pethistory.pet.dtos.DtoEsquemaVacunas;
import com.pethistory.pet.dtos.EsquemaVacunasCreateDto;

public interface EsquemaVacunasService {

    DtoEsquemaVacunas crear(EsquemaVacunasCreateDto dto);

    DtoEsquemaVacunas obtener(Long id);

    List<DtoEsquemaVacunas> listarPorMascota(Long idMascota);

    List<DtoEsquemaVacunas> listarPorVacuna(Long idVacuna);

    DtoEsquemaVacunas actualizar(DtoEsquemaVacunas dto);

    Map<String, Object> crearVarios(List<EsquemaVacunasCreateDto> lista);
}
