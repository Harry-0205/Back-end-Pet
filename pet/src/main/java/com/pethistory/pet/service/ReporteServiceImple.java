package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.mapper.ReporteMapper;

import com.pethistory.pet.models.Reporte;
import com.pethistory.pet.repositories.ReporteRepositories;

@Service
public class ReporteServiceImple implements ReporteService{

    private final ReporteRepositories proHisCliRepo;
    private final ReporteMapper proHisCliMap;

    public ReporteServiceImple(ReporteRepositories proHisCliRepo,ReporteMapper proHisCliMap)
    {
        this.proHisCliRepo=proHisCliRepo;
        this.proHisCliMap=proHisCliMap;
    }
    @Override
    public ReporteDto crear(ReporteDto dtoprohiscli){
        Reporte prohiscli=proHisCliMap.toProcedimientoHistoriaclinica(dtoprohiscli);

        Reporte guardado= proHisCliRepo.save(prohiscli);
        return proHisCliMap.toDto_procedimiento_historiaclinica(guardado);
    }
    @Override
    public List<ReporteDto>listarPorProcedimiento(Long procediId){
        return proHisCliRepo.findByProcedimiento_id(procediId)
        .stream()
        .map(proHisCliMap::toDto_procedimiento_historiaclinica)
        .collect(Collectors.toList());
    }
    @Override
    public List<ReporteDto>listarPorHistoria(Long idHistoria){
        return proHisCliRepo.findByHistoriaClinica_id(idHistoria)
        .stream()
        .map(proHisCliMap::toDto_procedimiento_historiaclinica)
        .collect(Collectors.toList());
    }

}

