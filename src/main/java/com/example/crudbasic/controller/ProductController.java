package com.example.crudbasic.controller;


import com.example.crudbasic.controller.Dto.ProductDto;
import com.example.crudbasic.entity.Product;
import com.example.crudbasic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @PostMapping("product/create")
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto
    ) {
        Product product = new Product()
                .setProductId(productDto.getProductId())
                .setProductName(productDto.getProductName())
                .setProductDetail(productDto.getProductDetail())
                .setPrice(productDto.getPrice());


        Product product1= productService.updateProduct(product);
        ProductDto productDto1 = new ProductDto().setProductId(product1.getProductId())
                .setProductName(product1.getProductName())
                .setProductDetail(product1.getProductDetail())
                .setPrice(product1.getPrice());

        return new ResponseEntity<>(productDto1, HttpStatus.CREATED);
    }

    @PostMapping("product/read")
    public List<Product> readProduct(){
        return productService.findAll();
    }

    @PostMapping("product/read1")
    public Optional<Product> readById(
            @RequestParam("productId")Long productId
    ){
       return productService.findById(productId);
    }

    @PostMapping("product/update")
    public ProductDto updateProduct(
            @RequestBody ProductDto productDto
    ){

       Product product = productService.findById(productDto.getProductId()).orElseThrow(
               ()->new RuntimeException("Not Found Productid" + productDto.getProductId()));

       product.setProductName(productDto.getProductName())
                .setProductDetail(productDto.getProductDetail())
                .setPrice(productDto.getPrice());

       product = productService.updateProduct(product);

        return new ProductDto().setProductId(product.getProductId())
                .setProductName(productDto.getProductName())
                .setProductDetail(product.getProductDetail())
                .setPrice(productDto.getPrice());
    }

    @GetMapping("product/delete")
    public void deleteProduct(
            @RequestParam("productId") Long productId
    ){
            productService.deleteProduct(productId);
    }

}
