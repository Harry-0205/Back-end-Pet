package com.pethistory.pet.service;

import java.util.List;

import com.pethistory.pet.dtos.AgendamientoDto;

public interface AgendamientoService {

    AgendamientoDto crear(AgendamientoDto agendamientoDto);
    AgendamientoDto buscarPorId(Long id);
    List<AgendamientoDto> listarTodos();
    AgendamientoDto actualizar(Long id, AgendamientoDto agendamientoDto);
    boolean eliminar(Long id);
}
