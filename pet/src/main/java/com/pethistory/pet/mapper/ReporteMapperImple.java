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
    public Reporte toProcedimientoHistoriaclinica(ReporteDto proHisDto){
        if (proHisDto ==null) {
            return null;
        }
        HistoriaClinica hiscli = histRep.findById(proHisDto.getIdhisto())
                .orElseThrow(()->new EntityNotFoundException("historiaclinica no encontrada"));
        
        Procedimiento procedi = proceRep.findById(proHisDto.getIdProcedi())
                .orElseThrow(()->new EntityNotFoundException("Procedimiento no encontrado"));

        Reporte ph = new Reporte();
        ph.setHistoriaClinica(hiscli);
        ph.setProcedimiento(procedi);
        ph.setAnotaciones(proHisDto.getAnota());
        
        Usuario usu = urep.findById(proHisDto.getUsuaDog()).orElseThrow(() -> new EntityNotFoundException("no se encvontro"));
        ph.setUsuario(usu);
        usu.setNom(proHisDto.getNombDoc());
        
        return ph;
    }
    @Override
    public ReporteDto toDto_procedimiento_historiaclinica(Reporte proHisCli){
        if ( proHisCli== null) {
            return null;
            
        }
        return new ReporteDto(
            proHisCli.getHistoriaClinica().getId(),
            proHisCli.getProcedimiento().getId(),
            proHisCli.getAnotaciones(),
            proHisCli.getUsuario().getId(),
            proHisCli.getUsuario().getNom()
        );
    }

}
