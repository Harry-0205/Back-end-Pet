package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.HistoriaClinicaDto;

public interface HistoriaclinicaService {
    HistoriaClinicaDto crear (HistoriaClinicaDto historiaClinicaDto);
    HistoriaClinicaDto buscarId(Long id);
    List<HistoriaClinicaDto> todaslasHis();

}
