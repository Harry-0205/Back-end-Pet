package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.models.Reporte;

public interface ReporteMapper {
    Reporte toProcedimientoHistoriaclinica(ReporteDto dto_procedimiento_historiaclinica);
    ReporteDto toDto_procedimiento_historiaclinica(Reporte procedimientoHistoriaclinica);

}
