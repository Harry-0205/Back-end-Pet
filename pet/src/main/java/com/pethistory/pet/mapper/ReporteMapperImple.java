package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.ReporteDto;
import com.pethistory.pet.models.HistoriaClinica;
import com.pethistory.pet.models.Procedimiento;
import com.pethistory.pet.models.Reporte;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.HistoriaClinicaRepositories;
import com.pethistory.pet.repositories.ProcedimientoRepositorio;
import com.pethistory.pet.repositories.UsuarioRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ReporteMapperImple implements ReporteMapper{

    private final ProcedimientoRepositorio proceRep;
    private final HistoriaClinicaRepositories histRep;
    private final UsuarioRepo urep;

    public ReporteMapperImple(ProcedimientoRepositorio proceRep,HistoriaClinicaRepositories histRep,UsuarioRepo urep){
        this.proceRep = proceRep;
        this.histRep = histRep;
        this.urep=urep;
    }
    @Override
    public Reporte toReporte(ReporteDto reporteDto){
        if (reporteDto ==null) {
            return null;
        }
        HistoriaClinica hiscli = histRep.findById(reporteDto.getIdHisto())
                .orElseThrow(()->new EntityNotFoundException("historia clinica no encontrada"));
        
        Procedimiento procedi = proceRep.findById(reporteDto.getIdProcedi())
                .orElseThrow(()->new EntityNotFoundException("Procedimiento no encontrado"));

        Reporte ph = new Reporte();
        ph.setHistoriaClinica(hiscli);
        ph.setProcedimiento(procedi);
        ph.setAnotaciones(reporteDto.getAnota());
        
        Usuario usu = urep.findById(reporteDto.getUsuaDog()).orElseThrow(() -> new EntityNotFoundException("no se encvontro"));
        ph.setUsuario(usu);
        
        return ph;
    }
    @Override
    public ReporteDto toReporteDto (Reporte reporte){
        if ( reporte== null) {
            return null;
            
        }
        return new ReporteDto(
            reporte.getId(),
            reporte.getHistoriaClinica().getId(),
            reporte.getProcedimiento().getId(),
            reporte.getAnotaciones(),
            reporte.getUsuario().getId(),
            reporte.getUsuario().getNom()
        );
    }

}
