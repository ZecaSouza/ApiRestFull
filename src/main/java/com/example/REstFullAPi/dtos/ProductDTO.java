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
        String description,
        @NotNull
        BigDecimal price
){
        public String getName() {
                return name;
        }

        public String getImage() {
                return image;
        }

        public String getDescription() { return description; }

        public BigDecimal getPrice() {
                return price;
        }
}
