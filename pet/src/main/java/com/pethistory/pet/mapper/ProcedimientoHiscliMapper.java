package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.Dto_procedimiento_historiaclinica;
import com.pethistory.pet.models.ProcedimientoHistoriaclinica;

public interface ProcedimientoHiscliMapper {
    ProcedimientoHistoriaclinica toProcedimientoHistoriaclinica(Dto_procedimiento_historiaclinica dto_procedimiento_historiaclinica);
    Dto_procedimiento_historiaclinica toDto_procedimiento_historiaclinica(ProcedimientoHistoriaclinica procedimientoHistoriaclinica);

}
