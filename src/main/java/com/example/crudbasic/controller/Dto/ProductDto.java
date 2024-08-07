package com.example.crudbasic.controller.Dto;


import com.example.crudbasic.entity.Product;
import com.example.crudbasic.repository.ProductRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Accessors(chain = true)
@Data
public class ProductDto {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productDetail;
    private BigDecimal price;

}
