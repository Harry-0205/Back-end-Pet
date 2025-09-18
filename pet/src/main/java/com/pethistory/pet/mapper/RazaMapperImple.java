package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.models.Especie;
import com.pethistory.pet.models.Raza;
import com.pethistory.pet.repositories.EspecieRepositorio;

import jakarta.persistence.EntityNotFoundException;

public class RazaMapperImple implements RazaMapper {

    private final EspecieRepositorio especieRepo;

    public RazaMapperImple(EspecieRepositorio especieRepo) {
        this.especieRepo = especieRepo;
    }
    @Override
    public Raza toRaza(RazaDto razaDto) {
        if (razaDto == null) {
            return null;
        }
        Raza raza = new Raza();
        raza.setId(razaDto.getIdRaza());
        raza.setRaza(razaDto.getRaza());

        Especie especie = especieRepo.findById(razaDto.getIdEspecie()).orElseThrow(()-> new EntityNotFoundException("Especie no encontrada"));
        raza.setEspecie(especie);
        return raza;
    }
    @Override
    public RazaDto toRazaDto(Raza raza){
        if (raza == null) {
            return null;
        }
        return new RazaDto(
            raza.getId(),
            raza.getRaza(),
            raza.getEspecie().getId(),
            raza.getEspecie().getNomEspecie());
    }
}
