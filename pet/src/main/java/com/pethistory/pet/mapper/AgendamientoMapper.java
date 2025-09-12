package com.pethistory.pet.mapper;

import com.pethistory.pet.dtos.AgendamientoDto;
import com.pethistory.pet.models.Agendamiento;

public interface AgendamientoMapper {
    Agendamiento toAgendamiento(AgendamientoDto agendamientoDto);
    AgendamientoDto toAgendamientoDto(Agendamiento agendamiento);
}
