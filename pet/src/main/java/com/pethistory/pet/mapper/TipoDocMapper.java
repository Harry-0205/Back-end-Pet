package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.TipoDocDto;
import com.pethistory.pet.models.TipoDoc;

public interface TipoDocMapper {
    TipoDoc toTipoDoc(TipoDocDto tipoDocDto);
    TipoDocDto toTipoDocDto(TipoDoc tipoDoc);

}
