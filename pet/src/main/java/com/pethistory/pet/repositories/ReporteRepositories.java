package com.pethistory.pet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.Reporte;
@Repository
public interface ReporteRepositories extends JpaRepository<Reporte, Long> {
    List<Reporte> findByHistoriaClinica_id (Long idHistoria);

    List<Reporte> findByProcedimiento_id (Long idProcedimiento);
}
