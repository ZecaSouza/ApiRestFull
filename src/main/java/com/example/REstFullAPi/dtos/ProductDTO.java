package com.example.REstFullAPi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(
        @NotBlank
        String name,
        @NotBlank
        String image,
        @NotBlank
        Integer price
) {



}
