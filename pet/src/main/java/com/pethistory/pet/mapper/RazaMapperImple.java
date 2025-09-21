package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.RazaDto;
import com.pethistory.pet.models.Raza;

@Component
public class RazaMapperImple implements RazaMapper {

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
