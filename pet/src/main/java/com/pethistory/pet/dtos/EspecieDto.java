package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecieDto {

    private Long idEspecie;
    @NotNull
    private String nomEspecie;
}
