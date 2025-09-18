package com.pethistory.pet.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColorDto {
    private Long idColor;
    @NotNull
    private String nomColor;

}
