package com.example.REstFullAPi.modules.product.service;

import com.example.REstFullAPi.dtos.ProductDTO;
import com.example.REstFullAPi.models.ProductModel;
import com.example.REstFullAPi.modules.product.controllers.ProductController;
import com.example.REstFullAPi.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<ProductModel> saveProduct(ProductDTO productDTO) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    public ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> productlList = productRepository.findAll();
        if (!productlList.isEmpty()){
            for (ProductModel product : productlList){
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productlList);
    }

    @Override
    public ResponseEntity<Object> getProduct(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
        }
        product.get().add(linkTo(methodOn(ProductController.class).getAllProduct()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @Override
    public ResponseEntity<Object> putProduct(UUID id, ProductDTO productDTO) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = product0.get();
        BeanUtils.copyProperties(productDTO, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @Override
    public ResponseEntity<Object> deletProduct(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productRepository.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

}
