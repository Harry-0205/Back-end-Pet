package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.Vacunas;

public interface VacunasRepo extends JpaRepository <Vacunas, Long> {

}
