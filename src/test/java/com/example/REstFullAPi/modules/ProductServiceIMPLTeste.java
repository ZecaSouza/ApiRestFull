package com.example.REstFullAPi.modules;

import static com.example.REstFullAPi.common.ProductConstants.PRODUCT_MODEL;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.REstFullAPi.common.ProductConstants;
import com.example.REstFullAPi.dtos.ProductDTO;
import com.example.REstFullAPi.models.ProductModel;
import com.example.REstFullAPi.modules.product.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceIMPLTeste {
    @Autowired
    private ProductServiceImpl productServiceIMPL;

    @Test
    public void CreateProduct_ValidData_ReturnProduct() {
       ProductModel sut = productServiceIMPL.saveProduct(PRODUCT_MODEL).getBody();

        assertThat(sut.getName()).isEqualTo(ProductConstants.PRODUCT_MODEL.getName());
        assertThat(sut.getImage()).isEqualTo(ProductConstants.PRODUCT_MODEL.getImage());
        assertThat(sut.getDescription()).isEqualTo(ProductConstants.PRODUCT_MODEL.getDescription());
        assertThat(sut.getValue()).isEqualTo(ProductConstants.PRODUCT_MODEL.getPrice());

    }



}
