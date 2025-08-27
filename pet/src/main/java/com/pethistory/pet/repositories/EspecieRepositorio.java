package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.Especie;

public interface EspecieRepositorio extends JpaRepository<Especie ,Long>{

}
