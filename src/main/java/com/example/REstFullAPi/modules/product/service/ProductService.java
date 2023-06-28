package com.example.REstFullAPi.modules.product.service;

import com.example.REstFullAPi.dtos.ProductDTO;
import com.example.REstFullAPi.models.ProductModel;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<ProductModel> saveProduct(ProductDTO productDTO);

}
