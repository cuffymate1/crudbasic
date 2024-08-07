package com.example.crudbasic.service;


import com.example.crudbasic.entity.Product;
import com.example.crudbasic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long productId){
        return productRepository.findById(productId);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow();
        productRepository.deleteById(productId);
    }

}

