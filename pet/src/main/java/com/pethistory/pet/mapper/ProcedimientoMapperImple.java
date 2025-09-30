package com.pethistory.pet.mapper;

import java.sql.Time;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.ProcedimientoDto;
import com.pethistory.pet.models.Procedimiento;

@Component
public class ProcedimientoMapperImple implements ProcedimientoMapper {

    @Override
    public Procedimiento toProcedimiento(ProcedimientoDto dto) {
        if (dto == null) {
            return null;
        }

        Procedimiento procedimiento = new Procedimiento();
        procedimiento.setId(dto.getIdProcedimiento());
        procedimiento.setProcedimiento(dto.getProcedimiento());
        procedimiento.setCosto(dto.getCosto());
        procedimiento.setDuracion(new Time(dto.getDuracion().getTime()));
        procedimiento.setAnotaciones(dto.getAnotaciones());

        return procedimiento;
    }

    @Override
    public ProcedimientoDto toProcedimientoDto(Procedimiento procedimiento) {
        if (procedimiento == null) {
            return null;
        }

        return new ProcedimientoDto(
            procedimiento.getId(),
            procedimiento.getProcedimiento(),
            procedimiento.getCosto(),
            procedimiento.getDuracion(),
            procedimiento.getAnotaciones()
        );
    }
}
