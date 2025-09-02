package com.pethistory.pet.repositories;

import com.pethistory.pet.models.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {
}
