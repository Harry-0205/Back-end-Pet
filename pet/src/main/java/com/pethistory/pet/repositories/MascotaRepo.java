package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.Mascota;

public interface MascotaRepo extends JpaRepository<Mascota, Long> {


}

