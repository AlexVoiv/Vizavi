package com.vizavi.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vizavi.application.models.dtos.ProductDTO;
import com.vizavi.application.models.entities.Product;
import com.vizavi.application.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ObjectMapper objectMapper){
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
}

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product productToSave = objectMapper.convertValue(productDTO, Product.class);
        Product savedProduct = productRepository.save(productToSave);
        log.info("Product created: " + productDTO);
        return objectMapper.convertValue(savedProduct, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> objectMapper.convertValue(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProductById(long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            Product updatedProduct = objectMapper.convertValue(productDTO, Product.class);
            updatedProduct.setId(existingProduct.getId());
            Product savedProduct = productRepository.save(updatedProduct);
            log.info("Product updated: " + productDTO);
            return objectMapper.convertValue(savedProduct, ProductDTO.class);
        }
        return null;
    }

    @Override
    public void deleteProductById(long productId) {
        log.info("Product with id " + productId + " was deleted.");
        productRepository.deleteById(productId);
    }
}

