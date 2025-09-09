package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.Cuenta;

public interface CuentaRepo extends JpaRepository<Cuenta, String> {

}
