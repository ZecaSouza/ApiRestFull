package com.example.REstFullAPi.modules.product.service;

import com.example.REstFullAPi.dtos.ProductDTO;
import com.example.REstFullAPi.models.ProductModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ResponseEntity<ProductModel> saveProduct(ProductDTO productDTO);
    ResponseEntity<List<ProductModel>> getAllProducts();
    ResponseEntity<ProductModel> getProduct(UUID id);
    ResponseEntity<Object> putProduct(UUID id, ProductDTO productDTO);
    ResponseEntity<Object> deletProduct(UUID id);

}
