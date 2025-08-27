package com.pethistory.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethistory.pet.models.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario,Long>{

}
