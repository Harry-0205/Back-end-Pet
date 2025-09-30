package com.pethistory.pet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethistory.pet.dtos.DtoEsquemaVacunas;
import com.pethistory.pet.dtos.EsquemaVacunasCreateDto;
import com.pethistory.pet.mapper.EsquemaVacunasMapper;
import com.pethistory.pet.models.EsquemaVacunas;
import com.pethistory.pet.models.EsquemaVacunasId;
import com.pethistory.pet.repositories.EsquemaVacunasRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EsquemaVacunasServiceImple implements EsquemaVacunasService {

    private final EsquemaVacunasRepositorio repo;
    private final EsquemaVacunasMapper mapper;

    public EsquemaVacunasServiceImple(EsquemaVacunasRepositorio repo, EsquemaVacunasMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DtoEsquemaVacunas crear(EsquemaVacunasCreateDto dto){
        EsquemaVacunas entity = mapper.toEsquema(dto);
        EsquemaVacunasId id = new EsquemaVacunasId(dto.getIdMascota(), dto.getIdVacuna());
        if (repo.existsById(id)){
            throw new IllegalStateException("El esquema de vacunas ya existe para la mascota y vacuna especificadas");
        }
        EsquemaVacunas saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public DtoEsquemaVacunas obtener(Long idMascota, Long idVacuna){
        EsquemaVacunasId id = new EsquemaVacunasId(idMascota, idVacuna);
        EsquemaVacunas entity = repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Esquema de vacunas no encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DtoEsquemaVacunas> listarPorMascota(Long idMascota){
        return repo.findByMascota_Id(idMascota).stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DtoEsquemaVacunas> listarPorVacuna(Long idVacuna){
        return repo.findByVacunas_Id(idVacuna).stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DtoEsquemaVacunas actualizar(DtoEsquemaVacunas dto){
        EsquemaVacunasId id = new EsquemaVacunasId(dto.getIdMascota(), dto.getIdVacuna());
        EsquemaVacunas entity = repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Esquema de vacunas no encontrado para actualizar"));
        mapper.updateEntity(entity, dto);
        EsquemaVacunas saved = repo.save(entity);
        return mapper.toDto(saved);
    }
    
    @Override
    @Transactional
    public Map<String, Object> crearVarios(List<EsquemaVacunasCreateDto> lista){
        int creados = 0, duplicados = 0, fallidos = 0;
        List<Map<String, Object>> detalles = new ArrayList<>();
        for (EsquemaVacunasCreateDto dto : lista){
            Map<String, Object> det = new HashMap<>();
            det.put("idMascota", dto.getIdMascota());
            det.put("idVacuna", dto.getIdVacuna());
            det.put("usuarioDoc", dto.getUsuarioDoc());
            try{
                crear(dto);
                det.put("estado", "CREADO");
                det.put("mensaje", "Creado exitosamente");
                creados++;
            }catch(IllegalStateException ex){
                det.put("estado", "DUPLICADO");
                det.put("mensaje", ex.getMessage());
                duplicados++;
            }catch(Exception ex){
                det.put("estado", "FALLIDO");
                det.put("mensaje", ex.getMessage());
                fallidos++;
            }
            detalles.add(det);
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("totalSolicitudes", lista.size());
        respuesta.put("totalCreados", creados);
        respuesta.put("totalDuplicados", duplicados);
        respuesta.put("totalFallidos", fallidos);
        respuesta.put("detalles", detalles);
        return respuesta;
    }
}
