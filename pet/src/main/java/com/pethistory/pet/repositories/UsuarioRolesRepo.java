package com.pethistory.pet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethistory.pet.models.UsuarioRolId;
import com.pethistory.pet.models.UsuarioRoles;

@Repository
public interface UsuarioRolesRepo extends JpaRepository<UsuarioRoles,UsuarioRolId> {
    List<UsuarioRoles> findByUsuario_id(Long idDoc);
    List<UsuarioRoles> findByRol_id(Long idRol);
    Optional<UsuarioRoles> findByUser(String user);

}
