package com.pethistory.pet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.ProHistoriaClinicaID;
import com.pethistory.pet.models.ProcedimientoHistoriaclinica;
@Repository
public interface ProcedimientoHistoriaClinicaRepositories extends JpaRepository<ProcedimientoHistoriaclinica, ProHistoriaClinicaID> {
    List<ProcedimientoHistoriaclinica> findByHistoriaClinica_id (Long idHistoria);

    List<ProcedimientoHistoriaclinica> findByProcedimiento_id (Long idProcedimiento);
}
