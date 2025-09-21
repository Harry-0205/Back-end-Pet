package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.Color;



@Repository
public interface ColorRepositorio extends JpaRepository<Color, Long>{
    Color findByNomColor(String nomColor);
}
