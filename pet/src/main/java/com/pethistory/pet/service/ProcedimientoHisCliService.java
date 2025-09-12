package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.Dto_procedimiento_historiaclinica;

public interface ProcedimientoHisCliService {
    Dto_procedimiento_historiaclinica crear(Dto_procedimiento_historiaclinica dtohiscli);
    List<Dto_procedimiento_historiaclinica> listarPorProcedimiento(Long procediId);
    List<Dto_procedimiento_historiaclinica> listarPorHistoria(Long idHistoria );
}
