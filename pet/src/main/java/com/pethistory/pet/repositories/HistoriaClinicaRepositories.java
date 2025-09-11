package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.HistoriaClinica;
@Repository
public interface HistoriaClinicaRepositories extends JpaRepository<HistoriaClinica, Long> {


}
