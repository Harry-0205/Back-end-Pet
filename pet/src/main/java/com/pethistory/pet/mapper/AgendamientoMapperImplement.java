package com.pethistory.pet.mapper;

import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.AgendamientoDto;
import com.pethistory.pet.models.Agendamiento;
import com.pethistory.pet.models.Estado;
import com.pethistory.pet.models.Mascota;
import com.pethistory.pet.models.Procedimiento;
import com.pethistory.pet.models.Veterinarias;
import com.pethistory.pet.repositories.EstadoRepositorio;
import com.pethistory.pet.repositories.MascotaRepo;
import com.pethistory.pet.repositories.ProcedimientoRepositorio;
import com.pethistory.pet.repositories.VeterinariasRepositories;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;

@Component
public class AgendamientoMapperImplement implements AgendamientoMapper{

    private final EstadoRepositorio estadoRepositorio;
    private final ProcedimientoRepositorio procedimientoRepositorio;
    private final VeterinariasRepositories veterinariasRepositories;

    public AgendamientoMapperImplement(
            EstadoRepositorio estadoRepositorio,
            ProcedimientoRepositorio procedimientoRepositorio,
            VeterinariasRepositories veterinariasRepositories) {
        this.estadoRepositorio = estadoRepositorio;
        this.procedimientoRepositorio = procedimientoRepositorio;
        this.veterinariasRepositories= veterinariasRepositories;
    }


    @Override
    public Agendamiento toAgendamiento(AgendamientoDto agendamientoDto) {
    if (agendamientoDto == null) {
        return null;
    }
    Agendamiento agendamiento = new Agendamiento();
    agendamiento.setIdCita(agendamientoDto.getIdCita());
    agendamiento.setFecAg(agendamientoDto.getFecAg());
    agendamiento.setFecAsi(agendamientoDto.getFecAsi());

    Procedimiento procedimiento = procedimientoRepositorio.findById(agendamientoDto.getIdProcedimientos()).orElseThrow(() -> new EntityNotFoundException("Tipo de id no encontrado"));
    agendamiento.setProcedimiento(procedimiento);
    procedimiento.setProcedimiento(agendamientoDto.getProcedimientos());
    Veterinarias veterinaria = veterinariasRepositories.findById(agendamientoDto.getIdVeterinarias()).orElseThrow(() -> new EntityNotFoundException("Veterinaria no encontrada"));
    agendamiento.setVeterinaria(veterinaria);
    veterinaria.setNom(agendamientoDto.getNomVet());
    Estado estado =estadoRepositorio.findById(agendamientoDto.getIdEstado()).orElseThrow(() -> new EntityNotFoundException("Estado no encontrado"));
    agendamiento.setEstado(estado);
    return agendamiento;
    }
    @Override
    public AgendamientoDto toAgendamientoDto (Agendamiento agendamiento){
        if (agendamiento == null) {
            return null;
            }
    return new AgendamientoDto(
    agendamiento.getIdCita(),
    agendamiento.getFecAg(),
    agendamiento.getFecAsi(),
    agendamiento.getProcedimiento().getIdProcedimiento(),
    agendamiento.getProcedimiento().getProcedimiento(),
    agendamiento.getVeterinaria().getIdVet(),
    agendamiento.getVeterinaria().getNom(),
    agendamiento.getEstado().getIdEstado(),
    agendamiento.getEstado().getCancelado(),
    agendamiento.getEstado().getRealizado());



        
    }
    

}
