package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.ColorDto;
import com.pethistory.pet.models.Color;

@Component
public class ColorMapperImple implements ColorMapper{
    @Override
    public Color toColor(ColorDto colorDto){
        Color color = new Color();
        color.setId(colorDto.getIdColor());
        color.setNomColor(colorDto.getNomColor());
        return color;
    }
    @Override
    public ColorDto toColorDto(Color color){
        return new ColorDto(
            color.getId(),
            color.getNomColor());
    }
}
