package com.example.hotrospring3.service;

import com.example.hotrospring3.model.Product;
import com.example.hotrospring3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }
}