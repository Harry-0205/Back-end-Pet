package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.dtos.RespAsignProDto;

public interface ReporteService {
    ReporteDto crear(ReporteDto reporteDto);
    List<ReporteDto> listarPorProcedimiento(Long procediId);
    List<ReporteDto> listarPorHistoria(Long idHistoria );
    RespAsignProDto asignar(List<ReporteDto>lista);
    
}
