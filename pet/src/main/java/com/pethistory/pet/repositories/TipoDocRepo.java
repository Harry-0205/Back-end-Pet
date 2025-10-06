package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.TipoDoc;
@Repository
public interface TipoDocRepo extends JpaRepository<TipoDoc,Long> {

}
