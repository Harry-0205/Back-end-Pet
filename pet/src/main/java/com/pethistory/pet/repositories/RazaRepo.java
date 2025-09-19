package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.Raza;


@Repository
public interface RazaRepo extends JpaRepository <Raza, Long>{
Raza findbyRaza(String Raza);
}
