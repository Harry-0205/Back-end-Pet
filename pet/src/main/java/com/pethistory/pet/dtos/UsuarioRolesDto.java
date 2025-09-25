package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioRolesDto {
    @NotNull(message = "Usuario no encontrado")
    private Long idDocumento;

    private String nomUsuario;


    @NotNull(message = "Rol no encontrado")
    private Long idRol;

    private String nomRol;

    @NotNull(message = "Veterinaria no encontrada")
    private Long idVeterinaria;

    private String nomVeterinaria;
}
