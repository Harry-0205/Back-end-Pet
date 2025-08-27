package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.Color;


public interface ColorRepositorio extends JpaRepository<Color, Long>{

}
