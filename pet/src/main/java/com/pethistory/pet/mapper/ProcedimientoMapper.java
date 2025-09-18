package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.ProcedimientoDto;
import com.pethistory.pet.models.Procedimiento;

public interface ProcedimientoMapper {
    Procedimiento toProcedimiento(ProcedimientoDto procedimientoDto);
    ProcedimientoDto toProcedimientoDto(Procedimiento procedimiento);
}
