package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.VeterinariasDto;
import com.pethistory.pet.models.Veterinarias;

@Component
public class VeterinariaMapperImplement implements VeterinariaMapper{

@Override
public Veterinarias toVeterinarias(VeterinariasDto veterinariasDto){
    if (veterinariasDto == null) {
        return null;
        
    }
    Veterinarias vete =new Veterinarias();
    vete.setIdVet(veterinariasDto.getIdVeterinaria());
    vete.setNom(veterinariasDto.getNombre());
    vete.setCorreo(veterinariasDto.getMail());
    vete.setFoto(veterinariasDto.getFotico());
    vete.setDirec(veterinariasDto.getDireccion());

    return vete;

    }
    @Override
    public VeterinariasDto 
    
}
