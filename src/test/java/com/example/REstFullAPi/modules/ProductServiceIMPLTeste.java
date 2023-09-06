package com.example.REstFullAPi.modules;

import static com.example.REstFullAPi.common.ProductConstants.PRODUCT_MODEL;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.REstFullAPi.dtos.ProductDTO;
import com.example.REstFullAPi.models.ProductModel;
import com.example.REstFullAPi.modules.product.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProductServiceImpl.class)
public class ProductServiceIMPLTeste {
    @Autowired
    private ProductServiceImpl productServiceIMPL;

    @Test
    public void CreateProduct_ValidData_ReturnPlanet() {
       ProductModel sut = productServiceIMPL.saveProduct(PRODUCT_MODEL).getBody();

       assertThat(sut).isEqualTo(PRODUCT_MODEL);
    }



}
