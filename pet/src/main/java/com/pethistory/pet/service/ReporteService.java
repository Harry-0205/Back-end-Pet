package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.ReporteDto;

public interface ReporteService {
    ReporteDto crear(ReporteDto dtohiscli);
    List<ReporteDto> listarPorProcedimiento(Long procediId);
    List<ReporteDto> listarPorHistoria(Long idHistoria );
    
}
