package com.pethistory.pet.mapper;
import com.pethistory.pet.dtos.VacunasDto;
import com.pethistory.pet.models.Especie;
import com.pethistory.pet.models.Vacunas;
import com.pethistory.pet.repositories.EspecieRepositorio;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;

@Component
public class VacunasMapperImple implements VacunasMapper {

    private final EspecieRepositorio espeRepo;

    public VacunasMapperImple(EspecieRepositorio espeRepo) {
        this.espeRepo = espeRepo;
    }

    @Override
    public Vacunas toVacunas(VacunasDto vacunasDto) {
        if (vacunasDto == null) {
            return null;
        }

        Vacunas vacunas = new Vacunas();
        vacunas.setId(vacunasDto.getIdVacuna());
        vacunas.setVacuna(vacunasDto.getVacuna());
        vacunas.setCosto(vacunasDto.getCosto());
        vacunas.setDosis(vacunasDto.getDosis());
        vacunas.setDuracion(vacunasDto.getDuracion());

        Especie espe = espeRepo.findById(vacunasDto.getIdEspecie()).orElseThrow(() -> new EntityNotFoundException("Especie no encontrada" + vacunasDto.getIdEspecie()));
        vacunas.setEspecie(espe);
                
        return vacunas;
    }

    @Override
    public VacunasDto toVacunasDto(Vacunas vacunas) {
        if (vacunas == null) {
            return null;
        }
        return new VacunasDto();
    }

}
