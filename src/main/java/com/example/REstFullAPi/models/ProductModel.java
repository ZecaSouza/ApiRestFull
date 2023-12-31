package com.example.REstFullAPi.models;

import com.example.REstFullAPi.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private String image;
    private String description;
    private BigDecimal price;

    public ProductModel(String name, String image,String description, Double value){
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = BigDecimal.valueOf(value.doubleValue());
    }

    public  ProductModel(ProductDTO productDTO){
        this.name = productDTO.name();
        this.image = productDTO.image();
        this.price = productDTO.price();
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return price;
    }

    public void setValue(BigDecimal value) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
