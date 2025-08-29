package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.Procedimiento;

@Repository
public interface ProcedimientoRepositorio extends JpaRepository<Procedimiento, Long>{

}
