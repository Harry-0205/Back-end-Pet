package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.HistoriaClinicaDto;
import com.pethistory.pet.models.HistoriaClinica;

public interface HistoriaClinicaMapper {
    HistoriaClinica tHistoriaClinica(HistoriaClinicaDto historiaClinicaDto);
    HistoriaClinicaDto toHistoriaClinicaDto(HistoriaClinica historiaClinica);

}
