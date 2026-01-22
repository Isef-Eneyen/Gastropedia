package com.IsefEneyen.Gastropedia.DTOs;

import lombok.*;

import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CategoryDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}
