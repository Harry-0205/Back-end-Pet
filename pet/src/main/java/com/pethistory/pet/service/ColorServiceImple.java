package com.pethistory.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pethistory.pet.dtos.ColorDto;
import com.pethistory.pet.mapper.ColorMapper;
import com.pethistory.pet.repositories.ColorRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColorServiceImple implements ColorService{

    private final ColorRepositorio colorRepo;
    private final ColorMapper colorMap;

    public ColorServiceImple(ColorRepositorio colorRepo, ColorMapper colorMap){
        this.colorRepo = colorRepo;
        this.colorMap = colorMap;
    }
    @Override
        public ColorDto buscarIdAll(Long id){
            return colorRepo.findById(id).map(colorMap::toColorDto).orElseThrow(()-> new EntityNotFoundException("Color no encontrado"));
    }
    @Override
        public List<ColorDto> listarTodos(){
            return colorRepo.findAll().stream().map(colorMap::toColorDto).collect(Collectors.toList());
    }
}
