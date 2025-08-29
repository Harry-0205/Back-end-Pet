package com.pethistory.pet.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"usuarioDoc","idRol"})
public class UsuarioRolId implements Serializable{
     public UsuarioRolId( Integer id1, Integer id2){
     }
     private Long usuarioDoc;
     private Long idRol;
}
