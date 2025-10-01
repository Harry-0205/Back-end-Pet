package com.pethistory.pet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.ProceAsignaDto;
import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.dtos.RespAsignProDto;
import com.pethistory.pet.mapper.ReporteMapper;
import org.springframework.transaction.annotation.Transactional;

import com.pethistory.pet.models.HistoriaClinica;
import com.pethistory.pet.models.Procedimiento;
import com.pethistory.pet.models.Reporte;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.HistoriaClinicaRepositories;
import com.pethistory.pet.repositories.MascotaRepo;
import com.pethistory.pet.repositories.ProcedimientoRepositorio;
import com.pethistory.pet.repositories.ReporteRepositories;
import com.pethistory.pet.repositories.UsuarioRepo;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ReporteServiceImple implements ReporteService{

    
    private final ReporteRepositories proHisCliRepo;
    private final ReporteMapper proHisCliMap;
    private final UsuarioRepo usuRep;
    private final ProcedimientoRepositorio proRep;
    private final HistoriaClinicaRepositories hisRep;


    public ReporteServiceImple(ReporteRepositories proHisCliRepo,ReporteMapper proHisCliMap,UsuarioRepo usuRep,ProcedimientoRepositorio proRep,HistoriaClinicaRepositories hisRep)
    {
        this.proHisCliRepo=proHisCliRepo;
        this.proHisCliMap=proHisCliMap;
        this.usuRep=usuRep;
        this.proRep=proRep;
        this.hisRep=hisRep;
    }
    @Override
    public ReporteDto crear(ReporteDto dtoprohiscli){
        Reporte prohiscli=proHisCliMap.toReporte(dtoprohiscli);

        Reporte guardado= proHisCliRepo.save(prohiscli);
        return proHisCliMap.toReporteDto(guardado);
    }
    @Override
    public List<ReporteDto>listarPorProcedimiento(Long procediId){
        return proHisCliRepo.findByProcedimiento_id(procediId)
        .stream()
        .map(proHisCliMap::toReporteDto)
        .collect(Collectors.toList());
    }
    @Override
    public List<ReporteDto>listarPorHistoria(Long idHistoria){
        return proHisCliRepo.findByHistoriaClinica_id(idHistoria)
        .stream()
        .map(proHisCliMap::toReporteDto)
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RespAsignProDto asignar(List<ReporteDto>lista){
        List<ProceAsignaDto> respuestas= new ArrayList<>();
        int asignados=0,cancelados=0;
        for(ReporteDto repdto:lista){
            ProceAsignaDto respuesta=new ProceAsignaDto();
            HistoriaClinica hc=hisRep.findById(repdto.getIdHisto()).orElseThrow(()->new EntityNotFoundException("Historia no encontrada"));
            Procedimiento pr=proRep.findById(repdto.getIdProcedi()).orElseThrow(()->new EntityNotFoundException("Procedimiento no encontrado"));
            Usuario us=usuRep.findById(repdto.getUsuaDog()).orElseThrow(()->new EntityNotFoundException("Usuario no encontrado"));
            respuesta.setNombreMas(hc.getMascota().getNombre());
            respuesta.setUsuDog(repdto.getUsuaDog());
            respuesta.setNomDoc(us.getNom());
            respuesta.setProcedi(pr.getProcedimiento());
            respuesta.setIdProcedi(repdto.getIdProcedi());
            respuesta.setIdHisto(hc.getId());
            try{
                Reporte rp= proHisCliMap.toReporte(repdto);
                proHisCliRepo.save(rp);
                respuesta.setEstado("ASIGNADO");
                respuesta.setMensaje("Asignación exitosa");
                asignados++;
            }catch(Exception e){
                respuesta.setMensaje("Error al asignar: " + e.getMessage());
                respuesta.setEstado("CANCELADO");
                cancelados++;
            }
            respuestas.add(respuesta);
        }
        RespAsignProDto resultado=new RespAsignProDto();
        resultado.setTotalSolicitados(lista.size());
        resultado.setTotalAsignados(asignados);
        resultado.setTotalCancelados(cancelados);
        resultado.setData(respuestas);
        return resultado;
    }

}

