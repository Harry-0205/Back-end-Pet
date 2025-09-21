package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.ColorDto;
import com.pethistory.pet.models.Color;

@Component
public class ColorMapperImple implements ColorMapper{
    @Override
    public ColorDto toColorDto(Color color){
        return new ColorDto(
            color.getId(),
            color.getNomColor());
    }
}
