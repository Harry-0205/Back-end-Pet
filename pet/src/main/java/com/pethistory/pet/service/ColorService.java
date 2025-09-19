package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.ColorDto;

public interface ColorService {
    ColorDto buscarIdAll(Long id);
    List<ColorDto> listarTodos();

}
