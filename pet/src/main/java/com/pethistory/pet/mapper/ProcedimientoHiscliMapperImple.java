package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.Dto_procedimiento_historiaclinica;
import com.pethistory.pet.models.HistoriaClinica;
import com.pethistory.pet.models.ProHistoriaClinicaID;
import com.pethistory.pet.models.Procedimiento;
import com.pethistory.pet.models.ProcedimientoHistoriaclinica;
import com.pethistory.pet.models.Usuario;
import com.pethistory.pet.repositories.HistoriaClinicaRepositories;
import com.pethistory.pet.repositories.ProcedimientoRepositorio;
import com.pethistory.pet.repositories.UsuarioRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ProcedimientoHiscliMapperImple implements ProcedimientoHiscliMapper{

    private final ProcedimientoRepositorio proceRep;
    private final HistoriaClinicaRepositories histRep;
    private final UsuarioRepo urep;

    public ProcedimientoHiscliMapperImple(ProcedimientoRepositorio proceRep,HistoriaClinicaRepositories histRep,UsuarioRepo urep){
        this.proceRep = proceRep;
        this.histRep = histRep;
        this.urep=urep;
    }
    @Override
    public ProcedimientoHistoriaclinica toProcedimientoHistoriaclinica(Dto_procedimiento_historiaclinica proHisDto){
        if (proHisDto ==null) {
            return null;
        }
        HistoriaClinica hiscli = histRep.findById(proHisDto.getIdhisto())
                .orElseThrow(()->new EntityNotFoundException("historiaclinica no encontrada"));
        
        Procedimiento procedi = proceRep.findById(proHisDto.getIdProcedi())
                .orElseThrow(()->new EntityNotFoundException("Procedimiento no encontrado"));

        ProHistoriaClinicaID id=new ProHistoriaClinicaID(proHisDto.getIdProcedi(),proHisDto.getIdhisto());

        ProcedimientoHistoriaclinica ph = new ProcedimientoHistoriaclinica();
        ph.setId(id);
        ph.setHistoriaClinica(hiscli);
        ph.setProcedimiento(procedi);
        ph.setAnotaciones(proHisDto.getAnota());
        
        Usuario usu = urep.findById(proHisDto.getUsuaDog()).orElseThrow(() -> new EntityNotFoundException("no se encvontro"));
        ph.setUsuario(usu);
        usu.setNom(proHisDto.getNombDoc());
        
        return ph;
    }
    @Override
    public Dto_procedimiento_historiaclinica toDto_procedimiento_historiaclinica(ProcedimientoHistoriaclinica proHisCli){
        if ( proHisCli== null) {
            return null;
            
        }
        return new Dto_procedimiento_historiaclinica(
            proHisCli.getHistoriaClinica().getId(),
            proHisCli.getProcedimiento().getId(),
            proHisCli.getAnotaciones(),
            proHisCli.getUsuario().getDoc(),
            proHisCli.getUsuario().getNom()
        );
    }

}
