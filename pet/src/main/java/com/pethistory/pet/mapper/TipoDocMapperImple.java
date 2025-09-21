package com.pethistory.pet.mapper;

import org.springframework.stereotype.Component;

import com.pethistory.pet.dtos.TipoDocDto;
import com.pethistory.pet.models.TipoDoc;

@Component
public class TipoDocMapperImple implements TipoDocMapper{
    @Override
    public TipoDoc toTipoDoc(TipoDocDto tipoDocDto){
        TipoDoc tipoDoc = new TipoDoc();
        tipoDoc.setIdTipo(tipoDocDto.getIdTipo());
        tipoDoc.setTipoDoc(tipoDocDto.getTipoDoc());
        return tipoDoc;
    }
    @Override
    public TipoDocDto toTipoDocDto(TipoDoc tipoDoc){
        return new TipoDocDto(
            tipoDoc.getIdTipo(),
            tipoDoc.getTipoDoc());
    }
}

