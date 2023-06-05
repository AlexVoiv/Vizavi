package com.vizavi.application.controllers;

import com.vizavi.application.models.dtos.ProductDTO;
import com.vizavi.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Validated
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProductById(productId, productDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}




