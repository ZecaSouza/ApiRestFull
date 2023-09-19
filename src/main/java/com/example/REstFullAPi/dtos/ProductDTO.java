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
        BigDecimal price
){
        public String getName() {
                return name;
        }

        public String getImage() {
                return image;
        }

        public BigDecimal getPrice() {
                return price;
        }
}
