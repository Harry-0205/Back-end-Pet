package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.EspecieDto;
import com.pethistory.pet.models.Especie;

@Component
public class EspecieMapperImple implements EspecieMapper{

    @Override
    public Especie toEspecie(EspecieDto especieDto){
        Especie especie = new Especie();
        especie.setId(especieDto.getIdEspecie());
        especie.setNomEspecie(especieDto.getNomEspecie());
        return especie;
    }
    @Override
    public EspecieDto toEspecieDto(Especie especie){
        return new EspecieDto(
            especie.getId(),
            especie.getNomEspecie());
    }
}
