package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.TipoDoc;

public interface TipoDocRepo extends JpaRepository<TipoDoc,Integer> {

}
