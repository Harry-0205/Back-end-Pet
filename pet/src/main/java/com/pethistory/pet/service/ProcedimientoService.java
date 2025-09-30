package com.pethistory.pet.service;

import com.pethistory.pet.dtos.ProcedimientoDto;
import java.util.List;

public interface ProcedimientoService {
    ProcedimientoDto crear(ProcedimientoDto dto);
    ProcedimientoDto buscarPorId(Long id);
    List<ProcedimientoDto> listarTodos();
    ProcedimientoDto actualizar(Long id, ProcedimientoDto dto);
}
