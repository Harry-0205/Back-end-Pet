package com.pethistory.pet.service;

import com.pethistory.pet.dtos.ProcedimientoDto;
import com.pethistory.pet.mapper.ProcedimientoMapper;
import com.pethistory.pet.models.Procedimiento;
import com.pethistory.pet.repositories.ProcedimientoRepositorio;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcedimientoServiceImple implements ProcedimientoService {

    private final ProcedimientoRepositorio ProRepo;
    private final ProcedimientoMapper ProMap;


    public ProcedimientoServiceImple(ProcedimientoRepositorio ProRepo, ProcedimientoMapper ProMap) {
        this.ProRepo = ProRepo;
        this.ProMap = ProMap;
}

    @Override
    public ProcedimientoDto crear(ProcedimientoDto dto) {
    Procedimiento procedimiento = ProMap.toProcedimiento(dto);
    Procedimiento saved = ProRepo.save(procedimiento);
    return ProMap.toProcedimientoDto(saved);
}

    @Override
    public ProcedimientoDto buscarPorId(Long id) {
    Procedimiento procedimiento = ProRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Procedimiento no encontrado con ID: " + id));
    return ProMap.toProcedimientoDto(procedimiento);
}

    @Override
    public List<ProcedimientoDto> listarTodos() {
    return ProRepo.findAll().stream().map(ProMap::toProcedimientoDto).collect(Collectors.toList());
}

    @Override
    public ProcedimientoDto actualizar(Long id, ProcedimientoDto dto) {
    Procedimiento existente = ProRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Procedimiento no encontrado con ID: " + id));

        existente.setProcedimiento(dto.getProcedimiento());
        existente.setCosto(dto.getCosto());
        existente.setDuracion(dto.getDuracion());
        existente.setAnotaciones(dto.getAnotaciones());

    Procedimiento actualizado = ProRepo.save(existente);
    return ProMap.toProcedimientoDto(actualizado);
}
}
