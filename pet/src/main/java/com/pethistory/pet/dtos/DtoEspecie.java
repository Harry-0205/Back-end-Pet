package com.pethistory.pet.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoEspecie {
    @NotNull
    private long idEsp;

    @NotNull
    @Size(min = 3, max = 30)
    private String esp;

}
