package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.HistoriaClinicaDto;
import com.pethistory.pet.models.HistoriaClinica;
import com.pethistory.pet.models.Mascota;
import com.pethistory.pet.repositories.MascotaRepo;

import jakarta.persistence.EntityNotFoundException;

@Component
public class HistoriaClinicaMapperImple implements HistoriaClinicaMapper{
    private final MascotaRepo masrep;

    public HistoriaClinicaMapperImple(
        MascotaRepo masrep){
            this.masrep=masrep;
        }

    @Override
    public HistoriaClinica tHistoriaClinica(HistoriaClinicaDto historiaClinicaDto){
        if (historiaClinicaDto == null) {
            return null;
            
        }
        HistoriaClinica hiscli = new HistoriaClinica();
        hiscli.setId(historiaClinicaDto.getId());
        hiscli.setAnotaciones(historiaClinicaDto.getAnot());
        hiscli.setFechaIni(historiaClinicaDto.getFechaI());
        
        Mascota masc = masrep.findById(historiaClinicaDto.getIdMascta()).orElseThrow(()-> new EntityNotFoundException("Mascota no encontrada"));
        hiscli.setMascota(masc);
        masc.setNombre(historiaClinicaDto.getNombreMascot());
        return hiscli;

    }
    @Override
    public HistoriaClinicaDto toHistoriaClinicaDto(HistoriaClinica historiaClinica){
        if (historiaClinica == null) {
            return null;
        }
        return new HistoriaClinicaDto(
            historiaClinica.getId(),
            historiaClinica.getFechaIni(),
            historiaClinica.getAnotaciones(),
            historiaClinica.getMascota().getId(),
            historiaClinica.getMascota().getNombre()
        );
    }
}
