package com.pethistory.pet.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoVacunas {
    @NotNull
    private Long idVac;

    @NotNull 
    @Size(min = 3,max = 50)
    private String vac;

    @NotNull
    private Long cost;

    @NotNull
    @Size(min = 3, max = 255)
    private String dos;

    @NotNull
    @Size(min = 3, max = 255)
    private String durac;
}
