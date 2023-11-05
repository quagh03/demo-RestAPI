package com.example.practiceapi.service;

import com.example.practiceapi.dto.ProductsDto;

import java.util.List;

public interface ProductsService {
    List<ProductsDto> getAllProducts();

    ProductsDto getProductById(Integer pid);
}
