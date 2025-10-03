package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.EsquemaVacunas;

@Repository
public interface EsquemaVacunasRepositorio extends JpaRepository<EsquemaVacunas, Long>{
    java.util.List<EsquemaVacunas> findByMascota_Id(Long idMascota);
    java.util.List<EsquemaVacunas> findByVacunas_Id(Long idVacuna);

}
