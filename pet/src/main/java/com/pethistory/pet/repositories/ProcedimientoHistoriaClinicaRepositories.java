package com.pethistory.pet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.ProHistoriaClinicaID;
import com.pethistory.pet.models.ProcedimientoHistoriaclinica;

public interface ProcedimientoHistoriaClinicaRepositories extends JpaRepository<ProcedimientoHistoriaclinica, ProHistoriaClinicaID> {
List<ProcedimientoHistoriaclinica> findByHistoriaClinica_id (Long idHistoria);

List<ProcedimientoHistoriaclinica> findByProcedimiento_id (Long idProcedimiento);



}
