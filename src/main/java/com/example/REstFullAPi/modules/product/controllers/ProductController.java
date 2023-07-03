package com.example.REstFullAPi.modules.product.controllers;


import com.example.REstFullAPi.dtos.ProductDTO;
import com.example.REstFullAPi.models.ProductModel;
import com.example.REstFullAPi.modules.product.service.ProductService;
import com.example.REstFullAPi.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
@Validated
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ProductModel>> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable(value = "id") UUID id ){
        return productService.getProduct(id);
    }

}
