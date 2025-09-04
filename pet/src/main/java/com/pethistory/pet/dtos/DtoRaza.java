package com.pethistory.pet.dtos;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoRaza {
    @NotNull
    private Long idRa;

    @NotNull
    @Size(min = 3, max = 30)
    private String Ra;

}
