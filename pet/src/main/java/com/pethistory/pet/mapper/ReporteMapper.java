package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.models.Reporte;

public interface ReporteMapper {
    Reporte toReporte(ReporteDto reporteDto);
    ReporteDto toReporteDto(Reporte reporte);

}
