package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.ColorDto;
import com.pethistory.pet.models.Color;

public interface ColorMapper {
    Color toColor(ColorDto colorDto);
    ColorDto toColorDto(Color color);

}
