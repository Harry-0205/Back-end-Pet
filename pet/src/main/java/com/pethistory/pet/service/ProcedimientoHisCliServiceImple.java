package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.Dto_procedimiento_historiaclinica;
import com.pethistory.pet.mapper.ProcedimientoHiscliMapper;
import com.pethistory.pet.models.ProHistoriaClinicaID;
import com.pethistory.pet.models.ProcedimientoHistoriaclinica;
import com.pethistory.pet.repositories.ProcedimientoHistoriaClinicaRepositories;

@Service
public class ProcedimientoHisCliServiceImple implements ProcedimientoHisCliService{

    private final ProcedimientoHistoriaClinicaRepositories proHisCliRepo;
    private final ProcedimientoHiscliMapper proHisCliMap;

    public ProcedimientoHisCliServiceImple(ProcedimientoHistoriaClinicaRepositories proHisCliRepo,ProcedimientoHiscliMapper proHisCliMap)
    {
        this.proHisCliRepo=proHisCliRepo;
        this.proHisCliMap=proHisCliMap;
    }
    @Override
    public Dto_procedimiento_historiaclinica crear(Dto_procedimiento_historiaclinica dtoprohiscli){
        ProcedimientoHistoriaclinica prohiscli=proHisCliMap.toProcedimientoHistoriaclinica(dtoprohiscli);

        ProHistoriaClinicaID id =new ProHistoriaClinicaID(dtoprohiscli.getIdhisto(),dtoprohiscli.getIdProcedi());
        if (proHisCliRepo.existsById(id)) {
            throw new IllegalStateException("ya existe historia clinica");
            
        }
        ProcedimientoHistoriaclinica guardado= proHisCliRepo.save(prohiscli);
        return proHisCliMap.toDto_procedimiento_historiaclinica(guardado);
    }
    @Override
    public List<Dto_procedimiento_historiaclinica>listarPorProcedimiento(Long procediId){
        return proHisCliRepo.findByProcedimiento_id(procediId)
        .stream()
        .map(proHisCliMap::toDto_procedimiento_historiaclinica)
        .collect(Collectors.toList());
    }
    @Override
    public List<Dto_procedimiento_historiaclinica>listarPorHistoria(Long idHistoria){
        return proHisCliRepo.findByHistoriaClinica_id(idHistoria)
        .stream()
        .map(proHisCliMap::toDto_procedimiento_historiaclinica)
        .collect(Collectors.toList());
    }
  
}

