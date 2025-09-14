package com.pethistory.pet.service;

import com.pethistory.pet.dtos.AgendamientoDto;
import com.pethistory.pet.mapper.AgendamientoMapper;
import com.pethistory.pet.models.Agendamiento;
import com.pethistory.pet.repositories.AgendamientoRepository;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamientoServiceImplement implements AgendamientoService {

    private final AgendamientoRepository repo;
    private final AgendamientoMapper map;

    public AgendamientoServiceImplement(AgendamientoRepository repo, AgendamientoMapper map) {
    this.repo = repo;
    this.map = map;
}

    @Override
    public AgendamientoDto crear(AgendamientoDto dto) {
    Agendamiento ag = map.toAgendamiento(dto);
    Agendamiento saved = repo.save(ag);
    return map.toAgendamientoDto(saved);
}

    @Override
    public AgendamientoDto buscarPorId(Long id) {
    Agendamiento ag = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamiento no encontrado con ID: " + id));
    return map.toAgendamientoDto(ag);
}

    @Override
    public List<AgendamientoDto> listarTodos() {
    return repo.findAll().stream().map(map::toAgendamientoDto).collect(Collectors.toList());
}

    @Override
    public AgendamientoDto actualizar(Long id, AgendamientoDto dto) {
    repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamiento no encontrado con ID: " + id));

    Agendamiento ag = map.toAgendamiento(dto);
    ag.setIdCita(id);
    Agendamiento saved = repo.save(ag);
    return map.toAgendamientoDto(saved);
}

    @Override
    public void eliminar(Long id) {
    Agendamiento ag = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamiento no encontrado con ID: " + id));
    repo.delete(ag);
}
}
