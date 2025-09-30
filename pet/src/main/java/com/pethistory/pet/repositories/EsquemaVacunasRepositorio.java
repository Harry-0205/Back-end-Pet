package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.EsquemaVacunas;
import com.pethistory.pet.models.EsquemaVacunasId;

@Repository
public interface EsquemaVacunasRepositorio extends JpaRepository<EsquemaVacunas, EsquemaVacunasId>{
    java.util.List<EsquemaVacunas> findByMascota_Id(Long idMascota);
    java.util.List<EsquemaVacunas> findByVacunas_Id(Long idVacuna);

}
